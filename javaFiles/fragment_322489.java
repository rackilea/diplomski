import java.io.*;

class Test {
    public static void main(String[] args) throws IOException {
        // Not disposing of any resources just for simplicity.
        // You wouldn't actually use code like this!
        FileOutputStream fos = new FileOutputStream("data");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        // Flush the preamble to disk
        bos.flush();

        FileInputStream fis = new FileInputStream("data");
        ObjectInputStream ois = new ObjectInputStream(fis);
    }
}