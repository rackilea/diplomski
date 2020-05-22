import javax.swing.JFileChooser;
import java.io.File;

public class ChooseFile 
{

    public static void main(String[] args) 
    {
        // Create JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Set the directory where the JFileChooser will open to
        // Uncomment one of these below as an example
        // fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        // fileChooser.setCurrentDirectory(new File("c:\\"));

        // Show the file select box to the user
        int result = fileChooser.showOpenDialog(null);   

        // Did the user select the "Open" button
        if(result == JFileChooser.APPROVE_OPTION)        
            System.out.println("File chosen: " + fileChooser.getSelectedFile());        
        else
            System.out.println("No file chosen");          
    } 
}