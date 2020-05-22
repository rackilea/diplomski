import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Delete {

/**
 * @param args
 * @throws IOException
 */
public static void main(String[] args) throws IOException {
    FileInputStream fstream = new FileInputStream("C:/file.txt");
    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String strLine;
    String user = "john";
    String pass = "doe";
    while ((strLine = br.readLine()) != null) {
        if ((user + "\t" + pass).equals(strLine)) {
            System.out.println("Sucess");
        }
    }

}