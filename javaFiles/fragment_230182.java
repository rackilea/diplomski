import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage[] dice = new BufferedImage[6];
        private JLabel die;

        public TestPane() {
            try {
                BufferedImage img = ImageIO.read(new File("/Users/swhitehead/Documents/Die.png"));
                int width = 377 / 6;
                for (int index = 0; index < 6; index++) {
                    dice[index] = img.getSubimage(width * index, 0, width, width);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            die = new JLabel(new ImageIcon(dice[0]));
            add(die, gbc);

            JButton roll = new JButton("Roll");
            add(roll, gbc);

            roll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    roll.setEnabled(false);
                    Timer timer = new Timer(250, new ActionListener() {
                        private int counter;
                        private int lastRoll;
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (counter < 20) {
                                counter++;
                                lastRoll = (int)(Math.random() * 6);
                                System.out.println(counter + "/" + lastRoll);
                                die.setIcon(new ImageIcon(dice[lastRoll]));
                            } else {
                                lastDieRollWas(lastRoll);
                                ((Timer)e.getSource()).stop();
                                roll.setEnabled(true);
                            }
                        }
                    });
                    timer.start();
                }
            });
        }

        protected void lastDieRollWas(int roll) {
            System.out.println("You rolled " + (roll + 1));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}