import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSystemIn {

    public static void main(final String[] args) throws IOException {
        // prepare test
        FileOutputStream fos = new FileOutputStream("testFile.txt");
        fos.write("testToken".getBytes());

        // configure env
        System.setIn(new FileInputStream("testFile.txt"));

        // perform read test
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("read: " + br.readLine());
    }

}