import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFile {

    public static void main(String[] args) {

        String fileFullPath = "C:\\Temp\\data.txt";

        /** verify that file exists */
        File checkFile = new File(fileFullPath);
        if (!checkFile.exists()) {
            System.err.println("error - file does not exist");
            System.exit(0);
        }        

        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(fileFullPath));

            /** keep reading lines while we still have some */
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    } //end main()

} //end ReadTextFile class