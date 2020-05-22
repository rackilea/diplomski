import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("c:\\tmp\\test.txt");
            DataInputStream din = new DataInputStream(in);
            out = new FileOutputStream("c:\\tmp\\test.out");
            DataOutputStream dout = new DataOutputStream(out);

            din.skipBytes(10);
            int length = din.readInt();
            System.out.println(length);
            int c;

            for (c = 0; c < length; c++) {
                // TODO: first read byte and check for EOF
                out.write(din.read());
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}