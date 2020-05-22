import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DragDirectionDemo {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                JFrame frame = new JFrame("Drag Direction Demo");
                frame.setSize(500, 500);
                frame.setVisible(true);
                frame.addMouseListener(new MouseListener() {

                    float lastY = 0;

                    public void mouseReleased(MouseEvent e) {
                        System.out.println("Mouse released at " + e.getY());
                        if (e.getY() < lastY) {
                            System.out.println("Upward swipe");
                        } else if (e.getY() > lastY) {
                            System.out.println("Downward swipe");
                        } else {
                            System.out.println("No movement");
                        }
                        ;
                    }

                    public void mousePressed(MouseEvent e) {
                        System.out.println("Mouse clicked at " + e.getY());
                        lastY = e.getY();
                    }

                    public void mouseEntered(MouseEvent e) {
                    }

                    public void mouseExited(MouseEvent e) {
                    }

                    public void mouseClicked(MouseEvent e) {
                    }
                });
            }
        });
    }
}