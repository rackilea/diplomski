import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RunDrones {

    public static int counterNum = 0;
    final JFrame display;
    private final JLabel counterStatus;
    private RectanglePane dialPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new RunDrones();
            }
        });
    }

    public RunDrones() {

        display = new JFrame();
        display.setLayout(new GridLayout());

        dialPane = new RectanglePane();
        display.add(dialPane);

        counterStatus = new JLabel("OOPS");
        counterStatus.setFont(new Font("Verdana", 1, 86));
        display.add(counterStatus);

        display.setSize(800, 400);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setLocationRelativeTo(null);
        display.setVisible(true);

        Timer dialTimer = new Timer(50, new Dial(dialPane));
        dialTimer.setInitialDelay(0);

        Timer counterTimer = new Timer(50, new Counter());

        dialTimer.start();
        counterTimer.start();
    }

    public static int getRandom() {
        int firstNum = new Random().nextInt(5) + 1;
        int secondNum = new Random().nextInt(5) + 1;
        return firstNum - secondNum;
    }

    public class RectanglePane extends JPanel {

        private int yPos;

        public void setYPos(int yPos) {
            this.yPos = yPos;
            repaint();
        }

        public int getYPos() {
            return yPos;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 

            g.setColor(Color.BLACK);
            int y = (getHeight() / 2) - 85;
            int x = (getWidth() - 20) / 2;
            g.drawRect(x, y, 40, 165);

//            y = (getHeight() + getYPos()) / 2;
            y = (getHeight() / 2) + getYPos();
            g.setColor(getForeground());
            g.fillRect(x, y, 40, 40);

        }

    }

    public class Dial implements ActionListener {

        private int dialNum;
        private RectanglePane pane;

        public Dial(RectanglePane pane) {
            this.pane = pane;
            pane.setForeground(Color.GREEN);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (dialNum >= -85 && dialNum <= 60) {
                dialNum += getRandom();
                pane.setYPos(dialNum);
            } else {
                pane.setForeground(Color.RED);
                ((Timer) e.getSource()).stop();
            }
        }

    }

    public class Counter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (counterNum >= -75 && counterNum <= 75) {
                counterNum += getRandom();
                counterStatus.setText(Integer.toString(counterNum));
            } else {
                ((Timer) e.getSource()).stop();
                counterStatus.setText("ALARM!!");
            }
        }

    }

}