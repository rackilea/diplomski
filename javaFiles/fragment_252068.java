import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GuiTest {

    private static final String DECK_URL = "http://i.stack.imgur.com/xNffR.png";
    private static final String CARD_URL = "http://i.stack.imgur.com/uVS1D.png";

    private static JPanel createDeckPanel() {
        JPanel panel = new JPanel();
        try {
            JLabel label = new JLabel(new ImageIcon(new URL(DECK_URL)));
            label.setText("DECK");
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);
            panel.add(label);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return panel;
    }

    private static JPanel createCenterPanel(int rows, int cols) {
        JPanel panel = new JPanel(new GridLayout(rows, cols));
        for (int i = 0; i < rows*cols; i++) {
            try {
                panel.add(new JLabel(new ImageIcon(new URL(CARD_URL))));
            } catch (Exception ex) {
                ex.printStackTrace();
            }   
        }
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(createDeckPanel(), BorderLayout.LINE_START);
                panel.add(createCenterPanel(2, 6));
                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}