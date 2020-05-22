import java.awt.Dimension;
import javax.swing.JOptionPane;

public class Starter {
    public static void main(String[] args) {
        PaintMe ring = new PaintMe();
        ring.setPreferredSize(new Dimension(250,30));
        JOptionPane.showMessageDialog(null, ring);
    }
}