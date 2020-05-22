import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

//public class HangingIndent extends JEditorPane {
public class HangingIndent extends JTextPane {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Negative (Hanging) first line indent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final HangingIndent app = new HangingIndent();
//        app.setEditorKit(new MyEditorKit());
        app.setText("The paragraph with long text is necessary to show how " +
                "hanging indent can be achieved. We should set not only the " +
                "first line indent but the same left indent.");
        StyledDocument doc=(StyledDocument)app.getDocument();
        SimpleAttributeSet attrs=new SimpleAttributeSet();
        StyleConstants.setFirstLineIndent(attrs, -50);
        StyleConstants.setLeftIndent(attrs, 50);

        doc.setParagraphAttributes(0,doc.getLength(),attrs, false);

        JScrollPane scroll = new JScrollPane(app);
        frame.getContentPane().add(scroll);

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public HangingIndent() {
        super();
    }
}