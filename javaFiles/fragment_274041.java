import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;

public class Main {

    private static LIButton bullets = new LIButton("Bullets", HTML.Tag.UL);
    private static JTextPane pane = new JTextPane();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    private static void create() throws HeadlessException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setPreferredSize(new Dimension(300, 300));
        pane.setContentType("text/html");
        pane.setText("<HTML><BODY><UL></UL></BODY></HTML>");
        frame.add(pane, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        panel.add(bullets);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class LIButton extends JButton {

        static final String LI_HTML = "<LI>item</LI>";

        public LIButton(String name, HTML.Tag parent) {
            super(new HTMLEditorKit.InsertHTMLTextAction(
                name, LI_HTML, parent, HTML.Tag.LI));
        }
    }
}