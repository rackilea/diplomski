import java.awt.Desktop;
import java.io.File;

public class OpenAppData {

    public static void main(String[] args) throws Exception {
        // Horribly platform specific.
        String appData = System.getenv("APPDATA");
        File appDataDir = new File(appData);
        // Get a sub-directory named 'texture'
        File textureDir = new File(appDataDir, "texture");
        Desktop.getDesktop().open(textureDir);
    }
}