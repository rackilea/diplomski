import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderControl {

    public static void main(String[] args) {
        new SliderControl();
    }

    public SliderControl() {
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

        private JSlider slider;
        private JTextField[] fields;

        private JTextField selectedField;

        public TestPane() {
            setLayout(new GridBagLayout());
            fields = new JTextField[3];
            FocusHandler focusHandler = new FocusHandler();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            for (int index = 0; index < 3; index++) {
                fields[index] = new JTextField(3);
                fields[index].addFocusListener(focusHandler);
                add(fields[index], gbc);
                gbc.gridy++;
            }
            gbc.fill = GridBagConstraints.HORIZONTAL;
            slider = new JSlider();
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (selectedField != null) {
                        selectedField.setText(String.valueOf(slider.getValue()));
                    }
                }
            });
            add(slider, gbc);
        }

        protected class FocusHandler extends FocusAdapter {

            @Override
            public void focusGained(FocusEvent e) {
                if (e.getComponent() instanceof JTextField) {
                    selectedField = (JTextField) e.getComponent();
                }
            }

        }
    }
}