import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 700;
    private static final int PREF_H = 400;
    private static final Color GRAD_COLOR_1 = new Color(255, 195, 225);
    private static final Color GRAD_COLOR_2 = new Color(139, 207, 236);

    public MainPanel() {
        setBackground(Color.GRAY);
        setSize(WIDTH, HEIGHT);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));

        // SOME OTHER STUFF
    }

    // to set the preferred size of the JPanel/GUI
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs); // ** don't forget this.
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, GRAD_COLOR_1, 0, getHeight(), GRAD_COLOR_2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }

    private static void createAndShowGui() {
        MainPanel mainPanel = new MainPanel();

        // create the JFrame when/if needed
        JFrame frame = new JFrame("Main");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
}