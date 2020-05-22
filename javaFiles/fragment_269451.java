import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class NumberLine3Test extends JPanel {
    private static final int MAX_X = 40;
    private static final int MAJOR_TICS = 4;
    private static final int MINOR_TICS = 5;
    private double value = 0.0;
    private NumberLine3 numberLine3 = new NumberLine3(MAX_X, MAJOR_TICS, MINOR_TICS, value);
    private JSlider slider = new JSlider(-MAX_X, MAX_X, 0);

    public NumberLine3Test() {
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.addChangeListener(ce -> {
            value = slider.getValue();
            numberLine3.setValue(value);
        });

        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);
        int ebGap = 40;
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(ebGap, ebGap, ebGap, ebGap));

        setLayout(new BorderLayout());
        add(numberLine3, BorderLayout.PAGE_START);
        add(sliderPanel);
    }

    private static void createAndShowGui() {
        NumberLine3Test mainPanel = new NumberLine3Test();

        JFrame frame = new JFrame("NumberLine3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}