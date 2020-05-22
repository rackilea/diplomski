import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ListenerDemo {
    public static final String PROP_NAME = "loginButtonClicked";

    public ListenerDemo() {
        DemoPanel panel = new DemoPanel();

        panel.addPropertyChangeListener(PROP_NAME, new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getPropertyName());
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    class DemoPanel extends JPanel {
        public DemoPanel() {
            JButton button = new JButton("Test");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    firePropertyChange(PROP_NAME, false, true);
                }
            });
            add(button);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListenerDemo();
            }
        });
    }
}