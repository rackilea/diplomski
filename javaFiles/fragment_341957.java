import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class testtest implements ActionListener {

    JButton button;
    MyDrawPanel panel;

    public static void main(String[] args) {
        testtest test = new testtest();
        test.go();

    }

    public void go() {
        JFrame frame = new JFrame("Balloon Balls");
        panel = new MyDrawPanel();
        button = new JButton("Restart");
        button.addActionListener(this);
        panel.add(button);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    private Timer timer;

    public void actionPerformed(ActionEvent e) {
        if (timer != null) {
            return;
        }
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (panel.update()) {
                    timer.stop();
                    timer = null;
                }
            }
        });
        timer.start();
    }

    class MyDrawPanel extends JPanel {

        private int xPosy = 0;
        private int yPosy = 0;

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        public boolean update() {
            xPosy++;
            yPosy++;
            repaint();

            return xPosy > getWidth() || yPosy > getHeight();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);            
            g.fillOval(xPosy, yPosy, 30, 30);
            g.setColor(Color.BLACK);
        }
    }
}