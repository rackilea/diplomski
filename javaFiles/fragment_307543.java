import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class RightToLeft {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JTextArea text = new JTextArea(10, 5);
                text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                text.setText("one/\n "
                        + "!two\n"
                        + ".three\n"
                        + "/four\n"
                        + "five!\n"
                        + "six.\n"
                        + "seven\n"
                        + "eight\n");
                JScrollPane pane = new JScrollPane(text);
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new JFrame("العنوان بالعربي");
                frame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                frame.add(pane);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}