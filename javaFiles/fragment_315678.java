import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class MathNotesPlus extends JFrame {

    JPanel panel;
    JTextPane textpane;
    StyledDocument document;

    public MathNotesPlus() {
        setTitle("Math Notes Plus");
        setSize(800, 600);
        initUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initUI(){
        //The panel.
        panel = new JPanel();
        //Textpane
        textpane = new JTextPane();
        textpane.setPreferredSize(new Dimension(700, 600));

        //Insertion of image into the document.
        try {
            Image image = ImageIO.read(new URL(
                "http://pscode.org/media/stromlo1.jpg"));

            document = (StyledDocument)textpane.getDocument();
            Style style = document.addStyle("StyleName", null);
            StyleConstants.setIcon(style, new ImageIcon(image));
            document.insertString(document.getLength(), "ignored text", style);
        } catch (Exception e){
            e.printStackTrace();
        }

        //Putting everything into the program.
        panel.add(textpane);
        add(panel);
        pack();
    }

    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            MathNotesPlus app = new MathNotesPlus();
                app.setVisible(true);
            }
        });
    }
}