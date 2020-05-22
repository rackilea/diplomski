import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

public class Main {

    public static void main(String[] args) throws IOException {
        TextEncryptor te = Encryptors.text("12345abc", "1234"); //password, salt.... in hex
        File file = new File("someFile.txt");
        FileWriter fw = new FileWriter(file);
        String encryptedText = te.encrypt("hellow world!");
        fw.append(encryptedText);
        fw.close();

        String text = IOUtils.toString(new FileInputStream(file));
        System.out.println(te.decrypt(text));

    }

}