import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

/** @see https://stackoverflow.com/questions/3971972 */
public class JSliderTest extends JPanel {

    public JSliderTest() {
        super(new GridLayout(0, 1));
        this.setPreferredSize(new Dimension(500, 400));
        this.add(genSliderPanel());
        this.add(genSliderPanel());
        this.add(genSliderPanel());
    }

    private JPanel genSliderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        JSlider slider = new JSlider(JSlider.HORIZONTAL);
        slider.setValue(40);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(Box.createVerticalGlue());
        panel.add(slider);
        panel.add(Box.createRigidArea(new Dimension(16, 16)));
        return panel;
    }

    private void display() {
        JFrame f = new JFrame("JSliderTest");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(this);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new JSliderTest().display();
            }
        });
    }
}