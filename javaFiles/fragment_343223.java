import org.junit.Test;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class testclass {

    @Test
    public void test() {
        String path = "C:/";
        // Let's assume these are the real JTextFields you have:
        final JTextField text1 = new JTextField();
        final JTextField text2 = new JTextField();
        final JTextField text3 = new JTextField();
        final JTextField text4 = new JTextField();
        final JTextField text5 = new JTextField();
        final JTextField text6 = new JTextField();

        // Here you just populates the List with the file names:
        List<FilePath> files = new ArrayList<FilePath>() {{
            add(new FilePath(text1, "A.txt"));
            add(new FilePath(text2, "B.txt"));
            add(new FilePath(text3, "C.txt"));
            add(new FilePath(text4, "D.txt"));
            add(new FilePath(text5, "E.txt"));
            add(new FilePath(text6, "F.txt"));
        }};

        // And finally you just go one by one checking if it exists and updates the JTextField Text.
        for (FilePath current : files) {
            File file = new File(String.format("%s/%s", path, current.getName()));
            if (file.exists() && !file.isDirectory()) {
                current.getTextField().setText(current.getName());
            }
            System.out.println(current.getTextField().getText());
        }
    }

    // This is just a simple class to hold both structures... 
    public class FilePath {
        private JTextField textField;
        private String name;

        public FilePath(JTextField textField, String path) {
            this.textField = textField;
            this.name = path;
        }

        public JTextField getTextField() {
            return textField;
        }

        public String getName() {
            return name;
        }
    }
}