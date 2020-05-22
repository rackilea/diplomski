import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class PlayerCard {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon playerIcon = new ImageIcon(getClass().getResource("/resources/1.png"));
                ImageIcon compIcon = new ImageIcon(getClass().getResource("/resources/14.png"));
                JLabel playerLabel = new JLabel(playerIcon);
                JLabel compLabel = new JLabel(compIcon);
                playerLabel.setText("Player Card");
                compLabel.setText("Computer Card");
                playerLabel.setVerticalTextPosition(JLabel.BOTTOM);
                compLabel.setVerticalTextPosition(JLabel.BOTTOM);
                playerLabel.setHorizontalTextPosition(JLabel.CENTER);
                compLabel.setHorizontalTextPosition(JLabel.CENTER);

                JPanel playerPanel = new JPanel();
                playerPanel.setBorder(new TitledBorder("Player"));
                playerPanel.add(playerLabel);

                JPanel compPanel = new JPanel();
                compPanel.setBorder(new TitledBorder("Computer"));
                compPanel.add(compLabel);

                JPanel panel = new JPanel();
                panel.add(playerPanel);
                panel.add(compPanel);

                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}