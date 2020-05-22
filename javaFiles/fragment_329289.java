import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CalculatorWithGBL {

    CalculatorWithGBL() {
        initUI();
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new GridBagLayout());
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH; // fill cell
        gbc.weightx = .5; //expand to fill container size
        gbc.weighty = .5; //  "    "   "      "       "   

        addComponentToContainer(new JButton("Clear Last"), 0, 0, 2);
        addComponentToContainer(new JButton("Clear All"), 2, 0, 2);

        addComponentToContainer(new JScrollPane(new JTextArea(4, 20)), 0, 1, 4);

        addComponentToContainer(new JButton("7"), 0, 2, 1);
        addComponentToContainer(new JButton("8"), 1, 2, 1);
        addComponentToContainer(new JButton("9"), 2, 2, 1);
        addComponentToContainer(new JButton("+"), 3, 2, 1);

        addComponentToContainer(new JButton("4"), 0, 3, 1);
        addComponentToContainer(new JButton("5"), 1, 3, 1);
        addComponentToContainer(new JButton("6"), 2, 3, 1);
        addComponentToContainer(new JButton("-"), 3, 3, 1);

        addComponentToContainer(new JButton("1"), 0, 4, 1);
        addComponentToContainer(new JButton("2"), 1, 4, 1);
        addComponentToContainer(new JButton("3"), 2, 4, 1);
        addComponentToContainer(new JButton("*"), 3, 4, 1);

        addComponentToContainer(new JButton("0"), 0, 5, 1);
        addComponentToContainer(new JButton("."), 1, 5, 1);
        addComponentToContainer(new JButton("="), 2, 5, 1);
        addComponentToContainer(new JButton("/"), 3, 5, 1);
    }

    private final void addComponentToContainer(
            Component c, int gridx, int gridy, int gridwidth) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;

        ui.add(c, gbc);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                CalculatorWithGBL o = new CalculatorWithGBL();

                JFrame f = new JFrame("Calculator with GBL");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }

    private JComponent ui = null;
    private GridBagConstraints gbc = new GridBagConstraints();
}