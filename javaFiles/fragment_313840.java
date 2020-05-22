import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GradientPaintBackground {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // the GUI as seen by the user (without frame)
                JPanel gui = new JPanel(new BorderLayout(15, 15)) {

                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);

                        Point point1 = new Point(10, 10);
                        Point point2 = new Point(
                                getWidth() - 10, 
                                getHeight() - 10);
                        final GradientPaint gp = new GradientPaint(
                                point1, Color.YELLOW,
                                point2, new Color(255, 225, 100),
                                true);

                        // we need a Graphics2D to use GradientPaint.
                        // If this is Swing, it should be one..
                        final Graphics2D g2 = (Graphics2D) g;
                        g2.setPaint(gp);
                        g.fillRect(0, 0, getWidth(), getHeight());
                    }
                };
                // adjust size to need.
                gui.setBorder(new EmptyBorder(20, 20, 20, 20));

                // Start:  Add components
                // adjust size to size of logo
                BufferedImage logo = new BufferedImage(
                        100, 40, BufferedImage.TYPE_INT_RGB);
                JLabel logoLabel = new JLabel(new ImageIcon(logo));
                gui.add(logoLabel, BorderLayout.NORTH);

                // adjust spacing to need
                JPanel menuPanel = new JPanel(new GridLayout(0, 1, 20, 20));
                menuPanel.setBorder(new EmptyBorder(5, 55, 5, 5));
                // allow the BG to show through..
                menuPanel.setOpaque(false);
                gui.add(menuPanel);
                String[] actionTexts = new String[]{
                    "Play Game", "Tutorial", "Other"
                };
                final JLabel messages = new JLabel("Ready to play?  "
                        + "Select an option");
                gui.add( messages, BorderLayout.PAGE_END );
                ActionListener al = new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() instanceof JButton) {
                            JButton b = (JButton)e.getSource();
                            messages.setText(b.getText() + " selected!");
                        }
                    }
                };
                for (int ii = 0; ii < actionTexts.length; ii++) {
                    JButton b = new JButton(actionTexts[ii]);
                    b.setContentAreaFilled(false);
                    b.setHorizontalAlignment(SwingConstants.LEADING);
                    b.setBorder(null);
                    b.addActionListener(al);
                    menuPanel.add(b);
                }
                // End:  Add components

                JFrame f = new JFrame("Gradient Background in JFrame");
                f.add(gui);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See https://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                f.setMinimumSize(f.getSize());
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}