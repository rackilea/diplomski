import java.io.*;

public class Test {
    public static void main(String args[]) throws Exception {
        File f = new File("test.txt");
        FileOutputStream fos = new FileOutputStream(f);
        BufferedOutputStream bos = new BufferedOutputStream(fos, 16384);
        for (int i=0;i<10000;++i) {
            bos.write(new byte[1024]);
        }
    }
}