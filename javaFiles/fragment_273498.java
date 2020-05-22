import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * this class is to optimize sound pattern playing
 *
 * reasoning:
 * - audio clips are for short repetitive files that don't need live changes to balance
 * - media players are for long files that will have the ability to swing with the visual patted
 * by updating the balance whenever needed (every few updates)
 */
public class AudioPlayer
{
    public enum Controller{
        MEDIA_PLAYER, AUDIO_CLIP;
    }

    /**
     * this class is to help other classes keep track of this particular state of the AudioPlayer
     */
    public class ControllerProperty extends SimpleObjectProperty<Controller>{
        SimpleBooleanProperty isMediaPlayerProperty = new SimpleBooleanProperty();

        @Override
        public void set(Controller newValue) {
            super.set(newValue);
            if (newValue == Controller.MEDIA_PLAYER)
                isMediaPlayerProperty.set(true);
            else
                isMediaPlayerProperty.set(false);
        }

        public ReadOnlyBooleanProperty isMediaPlayerProperty() {
            return isMediaPlayerProperty;
        }
    }
    // different controllers used
    private Media media;
    private MediaPlayer mediaPlayer;
    private AudioClip audioClip;

    // controllerProperty property indicator
    private ControllerProperty controllerProperty = new ControllerProperty();

    private boolean mediaDonePlaying = true;
    private double durationMillis;

    /**
     * Constructor. This will be the place where you can
     * @param srcUrl
     */
    public AudioPlayer(String srcUrl) {
        boolean formatSupported = true;
        try {
            durationMillis = getLength(srcUrl);
        } catch (IOException | LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            formatSupported = false;
        }
        // if file is long or format unsupported (not one of these: AudioSystem.getAudioFileTypes())
        if (durationMillis > 400 | !formatSupported){
            media = new Media(srcUrl);
            mediaPlayer = new MediaPlayer(media);
            controllerProperty.set(Controller.MEDIA_PLAYER);
            mediaPlayer.setOnEndOfMedia(() -> mediaDonePlaying = true);
        }
        else {
            audioClip = new AudioClip(srcUrl);
            controllerProperty.set(Controller.AUDIO_CLIP);
        }
    }

    /**
     * gets the audio duration of the provided source in milliseconds
     * @param path url string representation of the path
     * @return the length in milliseconds
     * @throws IOException
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     */
    public static double getLength(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException
    {
        AudioInputStream stream;
        stream = AudioSystem.getAudioInputStream(new URL(path));
        AudioFormat format = stream.getFormat();
        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
                .getSampleRate(), format.getSampleSizeInBits() * 2, format
                .getChannels(), format.getFrameSize() * 2, format
                .getFrameRate(), true); // big endian
            stream = AudioSystem.getAudioInputStream(format, stream);
        }
        DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat(),
            ((int) stream.getFrameLength() * format.getFrameSize()));
        Clip clip = (Clip) AudioSystem.getLine(info);
        clip.close();
        return clip.getBufferSize()
            / (clip.getFormat().getFrameSize() * clip.getFormat()
            .getFrameRate());
    }

    public void stop(){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    audioClip.stop();
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null){
                    mediaPlayer.stop();
                    mediaDonePlaying = true;
                }
                break;
        }
    }

    public void play(){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    if(!audioClip.isPlaying()){
                        audioClip.play();
                    }
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null){
                    mediaPlayer.play();
                    mediaDonePlaying = false;
                }
                break;
        }
    }

    public void pause(){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    audioClip.stop();
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null)
                    mediaPlayer.pause();
                break;
        }
    }

    /**
     * sets the balance of the player, if the controller is an {@link AudioClip}, the balance is 
     * updated at the next play cycle, if the controller is a {@link MediaPlayer} the balance is 
     * updated at the next time the {@link MediaPlayer} has Status.READY (read 
     * {@link MediaPlayer#setBalance(double)} for more details)
     * @param balance
     */
    public void setBalance(double balance){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    audioClip.setBalance(balance);
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null)
                    mediaPlayer.setBalance(balance);
                break;
        }
    }

    public String getSource(){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    return audioClip.getSource();
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null)
                    return media.getSource();
                break;
        }
        return null;
    }

    /**
     * @return if the file is done
     */
    public boolean isDonePlaying(){
        switch (controllerProperty.get())
        {
            case AUDIO_CLIP:
                if (audioClip != null)
                    return !audioClip.isPlaying();
                break;

            case MEDIA_PLAYER:
                if (mediaPlayer != null && media != null)
                    return mediaDonePlaying;
                break;
        }
        throw new IllegalStateException("Internal Error");
    }

    public ControllerProperty controllerProperty() {
        return controllerProperty;
    }
}