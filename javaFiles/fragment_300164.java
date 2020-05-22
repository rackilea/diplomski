import java.util.Scanner;
import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        Scanner sc = null;
        try {
            inputStream = new FileInputStream("IN File");
            outputStream = new FileOutputStream("OUT File");
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
                byte[] strToBytes = line.getBytes();
                outputStream.write(strToBytes);
                outputStream.write(System.getProperty("line.separator").getBytes());
            }
            // note that Scanner suppresses exceptions
            if (sc.ioException() != null) {
                throw sc.ioException();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (sc != null) {
                sc.close();
            }
        }
    }
}