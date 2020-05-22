import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JFrame fr=new JFrame("Multi caret test");
        JTextArea ta=new JTextArea("Test test test", 20, 40);
        MultiCaret c=new MultiCaret();
        c.setBlinkRate(500);
        c.setAdditionalDots(Arrays.asList(2,4,7));
        ta.setCaret(c);
        fr.add(ta);

        fr.pack();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }
}

class MultiCaret extends DefaultCaret {
    private List<Integer> additionalDots;

    public void setAdditionalDots(List<Integer> additionalDots) {
        this.additionalDots = additionalDots;
    }

    public void paint(Graphics g) {
        super.paint(g);

        try {
            TextUI mapper = getComponent().getUI();
            for (Integer addDot : additionalDots) {
                Rectangle r = mapper.modelToView(getComponent(), addDot, getDotBias());

                if(isVisible()) {
                    g.setColor(getComponent().getCaretColor());
                    int paintWidth = 1;
                    r.x -= paintWidth >> 1;
                    g.fillRect(r.x, r.y, paintWidth, r.height);
                }
                else {
                    getComponent().repaint(r);
                }
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

}