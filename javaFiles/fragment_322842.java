import java.nio.file.*;

public class JavaIO {
    public static void main(String[] args) {

        String dirString = "C:/Users/USER/Desktop/Test/Files";
        Path dirPath = Paths.get(dirString);
        if(Files.notExists(dirPath)){
            try{
                Files.createDirectory(dirPath);
            } catch(java.io.IOException e){
                System.out.println("createDirectory failed:" + e);
            }
        }
        System.out.println("Err");
        System.exit(1);
    }
}