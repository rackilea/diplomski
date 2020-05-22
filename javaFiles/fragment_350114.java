import java.io.*;

public class Program {
    public static void main(String[] args) throws IOException {
        String edit = "Edit";
        String fileName = "resources/File.txt";
        File file = new File(fileName);

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(edit.getBytes());
        }

        try (InputStream is = new FileInputStream(file)) {
            StringBuilder sb = new StringBuilder();
            int read = is.read();
            while (read != -1) {
                sb.append((char) read);
                read = is.read();
            }
            System.out.println(sb.toString());
        }
    }
}