import java.io.*;

public class WriteInts {
    public static void main(String[] args) throws IOException {
        DataOutputStream output = new DataOutputStream(new FileOutputStream(
                "data.dat"));

        for (int i = 0; i < 100; i++) {
            output.writeInt(i);
            System.out.println(i);
        }

        output.close();
    }

}