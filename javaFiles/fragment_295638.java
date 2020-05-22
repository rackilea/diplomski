import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class FlowLayoutRight {

    private JFrame frame = new JFrame();
    private JPanel panelNorth = new JPanel() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 50);
        }
    };
    private Icon icon = UIManager.getIcon("OptionPane.errorIcon");
    private JLabel label = new JLabel(icon);
    private JPanel panelCenter = new JPanel() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }
    };

    public FlowLayoutRight() {
        panelNorth.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelNorth.add(label);
        panelNorth.setBackground(Color.BLUE);
        panelCenter.setBackground(Color.ORANGE);
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(100, 100);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlowLayoutRight();
            }
        });
    }
}