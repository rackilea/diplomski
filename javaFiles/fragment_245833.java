import java.awt.Desktop;
import java.io.*;

public class BrowseDirectory {

    public static void main(String[] args) throws IOException {
        String userHomePath = System.getProperty("user.home");
        File userHome = new File(userHomePath);
        // uses the corect path separator for the OS
        File videos = new File(userHome, "Videos");
        Desktop.getDesktop().open(videos);
    }
}