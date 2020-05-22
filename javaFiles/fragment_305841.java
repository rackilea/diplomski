import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Snippet {
    public static void main(String[] args) {
        JFrame notepadFrame = createFrame();
        JDialog frDialog = new JDialog(notepadFrame);

        frDialog.setLayout(new GridLayout(3,4));

        JTextField txtFind = new JTextField();
        JTextField txtReplace = new JTextField();
        JButton btnFind = new JButton("Find");
        JButton btnReplace = new JButton("Replace");
        JButton btnReplaceAll = new JButton("Replace All");
        frDialog.add(new JLabel("Find: "));
        frDialog.add(txtFind);
        frDialog.add(new JLabel(""));
        frDialog.add(btnFind);
        frDialog.add(new JLabel("Replace with: "));
        frDialog.add(txtReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(btnReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));
        frDialog.add(btnReplaceAll);

        frDialog.pack();
        frDialog.setVisible(true);

        show(notepadFrame);

    }

    public static JFrame createFrame(){
        JFrame frame = new JFrame("Notepad Frame");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JTextArea());
        return frame;
    }

    public static void show(JFrame frame) {
        frame.setVisible(true);
    }
}