import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PlaySound extends JFrame{

    private Clip clip;

    public static void main(String [] args) {

        PlaySound app = new PlaySound();

    }

    public PlaySound() {
        JButton play = new JButton("Play");//here we make the button
        play.addActionListener(new ActionListener() {//here we tell what the button will do
        public void actionPerformed(ActionEvent e) {
            playTheSound();//when its clicked call this method
        }
    });

    this.add(play);
    this.pack();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
}

private void SoundEffect(URL url) {
    try {
        // Set up an audio input stream piped from the sound file.
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
        // Get a clip resource.
        clip = AudioSystem.getClip();
        // Open audio clip and load samples from the audio input stream.
        clip.open(audioInputStream);
    } catch (UnsupportedAudioFileException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (LineUnavailableException e) {
        e.printStackTrace();
    }
}

// Play or Re-play the sound effect from the beginning, by rewinding.
public void playTheSound() {

    URL url = getClass().getResource("click.wav");//You can change this to whatever other sound you have
    SoundEffect(url);//this method will load the sound

    if (clip.isRunning())
        clip.stop();   // Stop the player if it is still running
    clip.setFramePosition(0); // rewind to the beginning
    clip.start();     // Start playing

    }

}