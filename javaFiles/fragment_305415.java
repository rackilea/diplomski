import java.net.URL;
    import javax.sound.sampled.AudioFormat;
    import javax.sound.sampled.AudioInputStream;
    import javax.sound.sampled.AudioSystem;
    import javax.sound.sampled.DataLine;
    import javax.sound.sampled.SourceDataLine;

    public class AudioPlayer {

        private static final int EXTERNAL_BUFFER_SIZE = 128000;
        private URL url_;

        public AudioPlayer(URL filename) {
            url_ = filename;
        }

        public void play() throws Exception {

            AudioInputStream audioInputStream = null;
            audioInputStream = AudioSystem.getAudioInputStream(url_);

            AudioFormat audioFormat = audioInputStream.getFormat();

            SourceDataLine line = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,
                    audioFormat);
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(audioFormat);
            line.start();

            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    line.write(abData, 0, nBytesRead);
                }
            }

            line.drain();
            line.close();

        }
    }


    import javafx.async.RunnableFuture;

    public class PlayAudioImpl implements RunnableFuture {

        private AudioPlayer audio;

        public PlayAudioImpl(AudioPlayer audio) {
            this.audio = audio;
        }

        @Override
        public void run() throws Exception {
            audio.play();
        }
    }



    import javafx.async.JavaTaskBase;
    import javafx.async.RunnableFuture;

    import java.net.URL;

    public class PlayAudio extends JavaTaskBase  {
    public-init var source:String;

    public override function  create() : RunnableFuture {
        var player = new AudioPlayer(new URL(source));
        return new PlayAudioImpl(player);
    }

    public function play() : Void {
        start();
    }
   }