import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class TestFileChooser {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();

        File file = null;
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}