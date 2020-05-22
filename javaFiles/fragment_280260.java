import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class test {
    public static void main(String[] args) throws IOException {
            File fileDir = new File("test.txt");
            String japanese = "路権ち点節ヤトツ限聞ド勇売質タカア";
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir)));
            out.append(japanese);
            System.out.println(japanese);
            out.flush();
            out.close();
    }
}