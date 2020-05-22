import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DiceRoll {

    public static void main(String[] args) {
        new DiceRoll();
    }

    public DiceRoll() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private DiePanel diePane;

        public TestPane() {
            setLayout(new BorderLayout());
            diePane = new DiePanel();
            diePane.roll();
            add(diePane);
            JButton roll = new JButton("Roll");
            add(roll, BorderLayout.SOUTH);
            roll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new DieRoller(diePane).execute();
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class DieRoller extends SwingWorker<Void, Integer> {

        private DiePanel diePane;

        public DieRoller(DiePanel diePane) {
            this.diePane = diePane;
        }

        @Override
        protected void process(List<Integer> chunks) {
            diePane.roll();
        }

        @Override
        protected Void doInBackground() throws Exception {
            int rolls = ((int) Math.round(Math.random() * 100)) + 1;
            System.out.println("Rolls = " + rolls);
            for (int roll = 0; roll < rolls; roll++) {
                publish(roll);
                Thread.sleep(125);
            }
            return null;
        }
    }

    public class DiePanel extends JPanel {

        private int dieValue;
        private boolean onHold = false;

        public DiePanel() {
            super();
        }

        public void setDieValue(int dieValue) {
            this.dieValue = dieValue;
        }

        public int checkDieValue() {
            return dieValue;
        }

        public void roll() {
            dieValue = (int) ((Math.random() * 6) + 1);
            repaint();
        }

        public void changeOnHold() {
            onHold = !onHold;
        }

        public void unHold() {
            onHold = false;
        }

        public boolean checkOnHold() {
            return onHold;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (dieValue == 1) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(23, 23, 5, 5);
            } else if (dieValue == 2) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(7, 7, 5, 5);
                g.fillOval(38, 38, 5, 5);
            } else if (dieValue == 3) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(7, 7, 5, 5);
                g.fillOval(38, 38, 5, 5);
                g.fillOval(23, 23, 5, 5);

            } else if (dieValue == 4) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(7, 7, 5, 5);
                g.fillOval(38, 38, 5, 5);
                g.fillOval(7, 38, 5, 5);
                g.fillOval(38, 7, 5, 5);
            } else if (dieValue == 5) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(7, 7, 5, 5);
                g.fillOval(38, 38, 5, 5);
                g.fillOval(7, 38, 5, 5);
                g.fillOval(38, 7, 5, 5);
                g.fillOval(23, 23, 5, 5);
            } else if (dieValue == 6) {
                if (onHold == false) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillRoundRect(0, 0, 50, 50, 10, 10);
                if (onHold == true) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }
                g.fillOval(7, 7, 5, 5);
                g.fillOval(38, 38, 5, 5);
                g.fillOval(7, 38, 5, 5);
                g.fillOval(38, 7, 5, 5);
                g.fillOval(7, 23, 5, 5);
                g.fillOval(38, 23, 5, 5);
            }
        }
    }
}