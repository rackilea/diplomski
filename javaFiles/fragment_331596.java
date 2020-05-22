import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/** #see http://stackoverflow.com/questions/5979795 */
public class TextAreaLine {

    private static final String text1 =
        "Twas brillig and the slithy toves\n";
    private static final String text2 =
        "Did gyre and gimble in the wabe;";
    private static final JTextArea ta = new JTextArea(text1 + text2);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                display();
            }
        });
    }

    static void display() {
        JFrame f = new JFrame();
        ta.setWrapStyleWord(false);
        ta.setLineWrap(false);
        ta.setRows(3);
        f.add(ta);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        FontMetrics fm = ta.getFontMetrics(ta.getFont());
        List<String> texts = new ArrayList<String>();
        Dimension d = ta.getPreferredSize();
        String text = ta.getText();
        String line = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c != '\n') {
                if (fm.stringWidth(line + c) <= d.width) {
                    line += c;
                } else {
                    texts.add(line);
                    line = "" + c;
                }
            }
        }
        texts.add(line);
        for (String s : texts) {
            System.out.println("line: " + s);
        }
        System.out.println("line count: " + ta.getLineCount());
        System.out.println("preferred: " + d);
        System.out.println("bounds1: " + fm.getStringBounds(text1, null));
        FontRenderContext frc = new FontRenderContext(null, false, false);
        TextLayout layout = new TextLayout(text1, ta.getFont(), frc);
        System.out.println("layout1: " + layout.getBounds());
        System.out.println("bounds2: " + fm.getStringBounds(text2, null));
        layout = new TextLayout(text2, ta.getFont(), frc);
        System.out.println("layout2: " + layout.getBounds());
    }
}