import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

@SuppressWarnings("serial")
public class ColorPanels extends JPanel {
    public ColorPanels() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(new ColorPanel(Color.BLUE, 800, 200));
        add(new ColorPanel(Color.GREEN, 800, 400));
        add(new ColorPanel(Color.GRAY, 800, 200));
    }

    private static class ColorPanel extends JPanel {

        private int w;
        private int h;

        public ColorPanel(Color color, int w, int h) {
            this.w = w;
            this.h = h;
            setBackground(color);
        }

        @Override
        public Dimension getPreferredSize() {
            if (isPreferredSizeSet()) {
                return super.getPreferredSize();
            }
            return new Dimension(w, h);
        }

    }

    private static void createAndShowGui() {
        ColorPanels mainPanel = new ColorPanels();

        JFrame frame = new JFrame("ColorPanels");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}