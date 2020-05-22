import java.io.*;
public class tehMain {
    public static void main(String[] args) {
        try( BufferedReader br = new BufferedReader(new FileReader("files/txtfile")) ) {
            for (String line=br.readLine(); line != null; line=br.readLine()) {
                if (line.contains("AA")||line.contains("DD"))
                    continue;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}