import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Test extends JFrame {

    private String urls = "<a href=\"https://www.google.com\">Google me</a>";
    private JEditorPane textArea;

    public static void main(String[] args) {
        JFrame test = new Test();
        test.pack();
        test.setLocationRelativeTo(null);
        test.setVisible(true);
    }

    public Test() {
        super("Test");
        setPreferredSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JEditorPane();
        textArea.setEditable(false);
        textArea.setContentType("text/html");
        textArea.setEditorKit(JEditorPane.createEditorKitForContentType("text/html"));
        textArea.setBackground(Color.lightGray);
        textArea.setEnabled(true);
        textArea.setText(urls);
        textArea.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                    System.out.println(e.getURL());
                    System.out.println(e.getDescription());
                }
            }
        });
        add(new JScrollPane(textArea));
    }
}