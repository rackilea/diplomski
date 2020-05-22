import java.util.*;
import java.io.*;
import javax.sound.sampled.*;

public class getconc_1 {

public static void main(String[] args) {

            // get list of file names from audio directory

            File audDir = new File("/audiofiles");

           //define a list to contain the audio files names and path

              File[] filesList = audDir.listFiles();

           // assign contents of each wav file from filesList to a string           



          // read the string from the audio file into an AudioInputStream, and concatenate

            try {

                long length = 0;
                AudioInputStream clip = null;
                List<AudioInputStream> list = new ArrayList<AudioInputStream>();

                for (File file:filesList ) {
                    clip = AudioSystem.getAudioInputStream(new File(file.getPath()));
                    list.add(clip);
                    length += clip.getFrameLength();

                }
            if(length>0 && list.size()>0 && clip!=null) {

               AudioInputStream appendedFiles =
                        new AudioInputStream(
                            new SequenceInputStream(Collections.enumeration(list)),
                                clip.getFormat(),
                                length);

              AudioSystem.write(appendedFiles, 
                        AudioFileFormat.Type.WAVE, 
                        new File("wavAppended12.wav"));
      }
    } catch (Exception e) {
        e.printStackTrace();
     }
}

}