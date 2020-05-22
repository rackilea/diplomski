import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class GUI2 extends JPanel {
    private static final String[][] LABELS = {
            {"E-Mail", "E-Mail Address"},
            {"Phone", "Phone Number"},
            {"Address", "Street Address"},
            {"City", "City"},
            {"State", "State"} };
    private static final int TXT_FIELD_COLS = 15;
    private Map<String, JTextField> labelFieldMap = new HashMap<>();

    public GUI2() {
        setLayout(new GridLayout(0, 1));
        for (String[] label : LABELS) {
            add(createLegend(label));
        }
    }

    private JPanel createLegend(String[] label) {
        JLabel jLabel = new JLabel(label[1]);
        JTextField txtField = new JTextField(TXT_FIELD_COLS);
        labelFieldMap.put(label[0], txtField);

        JPanel legendPanel = new JPanel();
        legendPanel.setBorder(BorderFactory.createTitledBorder(label[0]));
        legendPanel.setLayout(new GridBagLayout());
        int anchor = GridBagConstraints.WEST;
        int fill = GridBagConstraints.HORIZONTAL;
        int ins = 3;
        Insets insets = new Insets(ins, ins, ins, 3* ins);
        GridBagConstraints gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, anchor, fill, insets, 0, 0);
        legendPanel.add(jLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.EAST;
        legendPanel.add(txtField, gbc);
        return legendPanel;
    }

    private static void createAndShowGui() {
        GUI2 mainPanel = new GUI2();

        JFrame frame = new JFrame("GUI2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}