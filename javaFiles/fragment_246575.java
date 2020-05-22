import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

public static void main(String[] args) {        
    Reader();
    Writer();
}
static void Reader(){
    BufferedReader br = null;

    try {

        String sCurrentLine;

        br = new BufferedReader(new FileReader("D:\\matrix.txt"));

        while ((sCurrentLine = br.readLine()) != null) {
            System.out.println(sCurrentLine);
        }

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            if (br != null)br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
static void Writer(){
    try {

        String content = "1010\n1111\n0000\n0101\n";
        System.out.println("Writing ... \n"+content);
        File file = new File("D:\\matrix.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.close();

        System.out.println("Done");

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}