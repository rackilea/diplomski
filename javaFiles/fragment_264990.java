import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.io.File;
public class FileSerial {

    private FileSerial(){}

    public static Config deserialize(){

        Config result;

        try {
            FileInputStream fis = new FileInputStream(Paths.get("path to your file"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Config) ois.readObject();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
    }

        return result;

    }

    public static void serialize(Config obj){
        try {

            File file = new File(Paths.get("path to file"));
            if(!file.exists()){
                file.getParentFile().mkdirs();
            }

            FileOutputStream fos = new FileOutputStream(path.toString());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}