import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Props {

    public Props() {
        try {
            File myFile = new File("props.properties");
            Properties properties = new Properties();
            properties.load(new FileInputStream(myFile));
            properties.remove("deletethis");
            OutputStream out = new FileOutputStream(myFile);
            properties.store(out, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[]args){
        new Props();
    }
}