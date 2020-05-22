import javax.swing.*;
import java.awt.event.*;

public class TransparentButton extends JButton {

    boolean opaque = false, areaFilled = false, borderPainted = false;

    public TransparentButton(Icon icon) {
        super(icon);
        initialise();
    }

    public TransparentButton(String text) {
        super(text);
        initialise();
    }

    private void initialise() {

        super.addMouseListener(new MouseListener() {
            public void mouseEntered(MouseEvent e) {
                opaque = true;
                areaFilled = true;
                borderPainted = true;
                reset();

            }

            public void mouseExited(MouseEvent e) {
                opaque = false;
                areaFilled = false;
                borderPainted = false;
                reset();
            }

            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        });
    }

    private void reset() {
        super.setOpaque(opaque);
        super.setContentAreaFilled(areaFilled);
        super.setBorderPainted(borderPainted);
    }
}