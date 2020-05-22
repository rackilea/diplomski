import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PlayerCard {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon playerIcon = new ImageIcon(getClass().getResource("/resources/1.png"));
                ImageIcon compIcon = new ImageIcon(getClass().getResource("/resources/14.png"));
                JLabel playerLabel = new JLabel(playerIcon);
                JLabel compLabel = new JLabel(compIcon);
                JLabel playerText = new JLabel("Player Card");
                JLabel compText = new JLabel("Computer Card");

                playerLabel.setHorizontalAlignment(JLabel.CENTER);
                compLabel.setHorizontalAlignment(JLabel.CENTER);

                JPanel playerCardPanel = new JPanel();
                playerCardPanel.add(playerLabel);

                JPanel compCardPanel = new JPanel();
                compCardPanel.add(compLabel);

                JPanel panel = new JPanel(new GridLayout(2, 2));
                panel.add(playerCardPanel);
                panel.add(compCardPanel);
                panel.add(playerText);
                panel.add(compText);

                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}