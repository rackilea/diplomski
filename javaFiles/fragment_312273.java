import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        private Timer timer;
        private JSlider slider;
        private JButton button;
        private JTextField field;

        public TestPane() {
            slider = new JSlider();
            field = new JTextField(4);
            button = new JButton(">");
            add(slider);
            add(button);
            add(field);

            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    field.setText(Integer.toString(slider.getValue()));
                }
            });
            slider.setValue(0);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer.isRunning()) {
                        stopTheClock();
                    } else {
                        startTheClock();
                    }
                }
            });
            timer = new Timer(500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int value = slider.getValue() + 1;
                    if (value >= slider.getMaximum()) {
                        stopTheClock();
                    } else {
                        slider.setValue(value);
                    }
                }
            });
        }

        protected void startTheClock() {
            slider.setValue(0);
            timer.start();
            button.setText("[]");
        }

        protected void stopTheClock() {
            timer.stop();
            button.setText(">");
        }

    }

}