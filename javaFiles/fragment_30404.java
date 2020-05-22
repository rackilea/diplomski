package testtextfile;

import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Main {

    public static void main(String[] args) {
        InputStream s = Main.class.getClassLoader().getResourceAsStream("hello.txt");
        Scanner sc = new Scanner(s);
        sc.useDelimiter("\\Z"); // read to the end of file. all at one.
        String contents = sc.next();
        JOptionPane.showMessageDialog(null, new JLabel(contents));
    }

}