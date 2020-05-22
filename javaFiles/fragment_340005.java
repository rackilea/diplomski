import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridFromGridBagLayout {

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    public GridFromGridBagLayout() {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 3; col++) {
                JButton b = new JButton("(" + row + ", " + col + ")");
                b.putClientProperty("column", col);
                b.putClientProperty("row", row);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        System.out.println("clicked column "
                                + btn.getClientProperty("column")
                                + ", row " + btn.getClientProperty("row"));
                    }
                });
                gbc.gridx = col;
                gbc.gridy = row;
                gbc.gridwidth = gbc.gridheight = 1;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.NORTHWEST;
                gbc.weightx = 33;
                gbc.weighty = 20;
                panel.add(b, gbc);
            }
        }
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GridFromGridBagLayout borderPanels = new GridFromGridBagLayout();
            }
        });
    }
}