import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadInts {
    public static void main(String[] args) throws IOException {
        DataInputStream input = new DataInputStream(new FileInputStream(
                "data.dat"));

        while (input.available() > 0) {
            int x = input.readInt();
            System.out.println(x);
        }

        input.close();
    }

}