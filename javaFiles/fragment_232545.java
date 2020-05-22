import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TestHsvChooser2 {
    // ***** choose which color panel / color bar you'd like to test:
    // private static final ColorProperty COLOR_PROP = ColorProperty.HUE;
    // private static final ColorProperty COLOR_PROP = ColorProperty.BRIGHTNESS;
    private static final ColorProperty COLOR_PROP = ColorProperty.SATURATION;

    private static void createAndShowGui() {
        HsvChooserPanel2 hsvChooserPanel = new HsvChooserPanel2(COLOR_PROP);

        JPanel testPanel = new JPanel();
        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(testPanel);
        outerPanel.setBorder(BorderFactory.createTitledBorder("Test Panel"));

        hsvChooserPanel.addPropertyChangeListener(HsvChooserPanel2.COLOR, pce -> {
            Color c = (Color) pce.getNewValue();
            testPanel.setBackground(c);
        });

        JPanel gridPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        gridPanel.add(hsvChooserPanel);
        gridPanel.add(outerPanel);

        JFrame frame = new JFrame("HSV Chooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gridPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}