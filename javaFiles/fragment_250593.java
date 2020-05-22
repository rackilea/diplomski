import java.awt.Desktop;
import java.awt.HeadlessException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * @see https://stackoverflow.com/a/16447176/230513
 * @see https://stackoverflow.com/a/14170141/230513
 */
public class Test {

    public static void main(String[] argv) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                display();
            }
        });
    }

    private static String create(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to <a href=");
        sb.append("'http://www.example.com'>Example ");
        sb.append(i);
        sb.append("</a>.<br>");
        return sb.toString();
    }

    private static void display() throws HeadlessException {
        JEditorPane jep = new JEditorPane();
        jep.setContentType("text/html");
        StringBuilder sb = new StringBuilder();
        sb.append("<b>Welcome</b>:<br><hr>");
        for (int i = 1; i <= 3; i++) {
            sb.append(create(i));
        }
        sb.append("<hr>");
        jep.setText(sb.toString());
        jep.setEditable(false);
        jep.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(e.getEventType())) {
                    System.out.println(e.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(e.getURL().toURI());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JFrame f = new JFrame("HyperlinkListener");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(jep);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}