import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class AdminToken extends JFrame {

    public AdminToken()
    {
        setupGUI();
        setVisible(true);
        setResizable(true);
        pack();
    }
    void setupGUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,2));

        for(int row =0; row < 6; row++ ) {
            panel.add(new JLabel("Label "+row));
            panel.add(new JButton("Delete"));
        }

        JScrollPane scrollPane = new JScrollPane (panel);
        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AdminToken() );
    }
}