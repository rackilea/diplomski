import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class HighlightBorder extends MouseAdapter {

    JPanel p;
    LineBorder border;

    public HighlightBorder() {
        JFrame j = new JFrame();
        p = new JPanel();
        border = new LineBorder(Color.red, 2);
        j.getContentPane().add(p);
        j.setSize(400, 300);
        j.setVisible(true);
        p.addMouseListener(this);
    }

    public void mouseEntered(MouseEvent e) {
        p.setBorder(border);
    }

    public void mouseExited(MouseEvent e) {
        p.setBorder(null);
    }

    public static void main(String[] args) {
        new HighlightBorder();
    }
}