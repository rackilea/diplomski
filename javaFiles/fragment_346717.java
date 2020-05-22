import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ImageByDrawing {

    public ImageByDrawing() {
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/stackblack.jpg"));
        JLabel label = new JLabel(icon);
        label.setBorder(new TitledBorder("JLabel with ImageIcon"));

        JCheckBox germanBox = new JCheckBox("German");
        germanBox.setOpaque(false);
        JCheckBox englishBox = new JCheckBox("English");
        englishBox.setOpaque(false);
        JPanel boxPanel = new JPanel();
        boxPanel.setBorder(new TitledBorder("JPanel with default FlowLayout"));
        boxPanel.setOpaque(false);
        boxPanel.add(germanBox);
        boxPanel.add(englishBox);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(label, BorderLayout.CENTER);
        centerPanel.add(boxPanel, BorderLayout.SOUTH);
        centerPanel.setBorder(new TitledBorder("JPanel with BorderLayout"));
        centerPanel.setOpaque(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(centerPanel);
        mainPanel.setBorder(new TitledBorder("JPanel with GridBagLayout"));
        mainPanel.setBackground(new Color(216, 252, 202));

        JFrame frame = new JFrame();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageByDrawing();
            }
        });
    }
}