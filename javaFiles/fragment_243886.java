import java.io.BufferedReader;
      import java.io.BufferedWriter;
      import java.io.File;
      import java.io.FileReader;
      import java.io.FileWriter;
      import java.io.IOException;
      import java.util.HashSet;

      public class HisSaver {
        private HashSet<String> uniqueTester = new HashSet<String>();

        private String fileLocation="/mnt/sdcard/out.txt";

        private static HisSaver instance = null;


        private HisSaver() {
            readWordsFromFile();
        }

        public static HisSaver getInstance() {
            if(instance == null)
                instance = new HisSaver();
            return instance;
        }

        public void saveWord(String word) {
            if(!uniqueTester.contains(word)) {
                uniqueTester.add(word);
                writeWordToFile(word);
            }
        }

        private void writeWordToFile(String word) {
          try {
               BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                       fileLocation), true));
               bw.write(word);
               bw.newLine();
               bw.close();
          } catch (IOException e) {

          }
        }

        private void readWordsFromFile() {
          try {
            BufferedReader br = new BufferedReader(new FileReader(new File(
                fileLocation)));
            String line;
            while((line = br.readLine()) != null) {
                if(!uniqueTester.contains(line)) {
                    uniqueTester.add(line);
                }
            }
          } catch (IOException e) {

          }
        }
      }