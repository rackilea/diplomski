import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class TestRadioCombo extends JPanel {
    private static final String[] DATA = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    private static final String[] INNER_DATA = {"One", "Two", "Three", "Four", "Five"};
    private static final int GAP = 3;
    public TestRadioCombo() {
        ButtonGroup buttonGroup = new ButtonGroup();

        setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));
        setLayout(new GridBagLayout());
        for (String datum : DATA) {

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            for (String innerDatum : INNER_DATA) {
                String item = datum + " - " + innerDatum;
                model.addElement(item);
            }
            RadioCombo<String> radioCombo = new RadioCombo<>(datum, model);
            buttonGroup.add(radioCombo.getRadioBtn());
            addRadioCombo(radioCombo);
        }
    }

    private void addRadioCombo(RadioCombo<String> radioCombo) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(GAP, GAP, GAP, 2 * GAP);
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(radioCombo.getRadioBtn(), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(GAP, GAP, GAP, GAP);
        add(radioCombo.getCombo(), gbc);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TestRadioCombo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}