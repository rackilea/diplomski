import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ConcurrencyRace {

    //-----------------------------------------------------------------
    //  Creates and displays the main program frame.
    //-----------------------------------------------------------------
    public ConcurrencyRace() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Timer timer = new Timer(200, null);
                JFrame frame = new JFrame();
                frame.add(new ButtonPane(timer), BorderLayout.NORTH);
                frame.add(new RacePane(timer));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new ConcurrencyRace();
    }

    public class ButtonPane extends JPanel {

        private JButton startRace = new JButton("Start The Race!");
        private JButton stopRace = new JButton("Stop The Race!");

        public ButtonPane(Timer timer) {
            startRace.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.start();
                }
            });

            stopRace.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.stop();
                }
            });

            setLayout(new GridBagLayout());
            add(startRace);
            add(stopRace);
        }

    }

    private class RacePane extends JPanel {

        private int blueDraw = 5, redDraw = 5;
        private Random rn = new Random();

        public RacePane(Timer timer) {
            timer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (updateState()) {
                        ((Timer)e.getSource()).stop();
                    }
                }
            });
        }

        protected boolean updateState() {
            blueDraw += rn.nextInt(10) + 1;
            redDraw += rn.nextInt(10) + 1;
            repaint();

            return blueDraw >= getWidth() || redDraw >= getWidth();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(600, 250);
        }

        @Override
        public void paintComponent(Graphics page) {
            System.out.println(">>");
            super.paintComponent(page);
            page.setColor(Color.blue);
            page.fillRect(0, 80, blueDraw, 20);

            page.setColor(Color.red);
            page.fillRect(0, 120, redDraw, 20);
        }
    }
}