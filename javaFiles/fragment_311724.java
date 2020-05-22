import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


@SuppressWarnings("serial")
public class BouncingLabels extends JFrame {

    // this is our bouncing label component. it bounces around its parent. this could
    // be pulled out into its own class file; its in here to keep the example self
    // contained.
    static class BouncingLabel extends JLabel {

        private int fieldWidth, fieldHeight; // width/height of parent at creation time.
        private int velX = 1, velY = 1; // current x and y velocity.

        // constructor sets base label properties and starts a timer.
        public BouncingLabel (int fieldWidth, int fieldHeight) {

            this.fieldWidth = fieldWidth;
            this.fieldHeight = fieldHeight;

            setBounds(0, 0, 60, 20);
            setOpaque(true);
            setBackground(Color.RED);
            setForeground(Color.WHITE);
            setText("HELLO");
            setVisible(true);

            // timer will call step() every 10ms.
            new Timer(10, new ActionListener() {
                @Override public void actionPerformed (ActionEvent e) {
                    step();
                }
            }).start();

        }

        // step updates the component position. note that no explicit painting is done.
        private void step () {

            int x = getX();
            int y = getY();
            int maxx = fieldWidth - getWidth();
            int maxy = fieldHeight - getHeight();

            x += velX;
            y += velY;

            if ((x >= maxx && velX > 0) || (x <= 0 && velX < 0))
                velX = -velX;
            if ((y >= maxy && velY > 0) || (y <= 0 && velY < 0))
                velY = -velY;

            setLocation(x, y);

        }

    }

    // BouncingLabels is our main frame; click on it to add a label.
    public BouncingLabels () {

        // work with the content pane, not the frame itself.
        final Container c = getContentPane();
        c.setPreferredSize(new Dimension(300, 300));
        c.setLayout(null);
        setResizable(false);
        pack();

        // add an initial bouncing object.
        c.add(new BouncingLabel(c.getWidth(), c.getHeight()));

        // clicking on the frame will add a new object.
        addMouseListener(new MouseAdapter() {
            @Override public void mouseClicked (MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1)
                    c.add(new BouncingLabel(c.getWidth(), c.getHeight()));
            }            
        });

    }

    // main method creates and shows a BouncingLabels frame.
    public static void main (String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run () {
                BouncingLabels b = new BouncingLabels();
                b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                b.setLocationRelativeTo(null);
                b.setVisible(true);
            }
        });
    }

}