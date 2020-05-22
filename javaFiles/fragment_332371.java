import java.awt.Container;
import java.text.ParseException;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.text.MaskFormatter;

public class Test {

    public static void main(String args[]) throws ParseException {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = f.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        MaskFormatter mf1 = new MaskFormatter("######.###");
        mf1.setPlaceholderCharacter('_');
        JFormattedTextField ftf1 = new JFormattedTextField(mf1);
        content.add(ftf1);

        f.setSize(300, 100);
        f.setVisible(true);
    }

}