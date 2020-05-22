import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class ShowRoomLayout {

    private JComponent ui = null;

    ShowRoomLayout() {
        initUI();
    }

    private JPanel getShowRoomPanel(int num) {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new TitledBorder("GridBagLayout"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        p.add(new JLabel("Name:Honda Showroom" + num), gbc);

        gbc.gridx = 1;
        p.add(new JLabel("City:Mandsaur"), gbc);

        gbc.gridx = 2;
        p.add(new JLabel("Address:25 Chakrawati Colony Railway Station Road"), gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        p.add(new JLabel("Vehicle Name:Activa"), gbc);

        gbc.gridx = 1;
        p.add(new JLabel("Vehicle Version:2017"), gbc);

        gbc.gridx = 2;
        p.add(new JLabel("Vehicle Companies:Honda"), gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        p.add(new JButton("Go"), gbc);

        return p;
    }

    public void initUI() {
        if (ui != null) {
            return;
        }

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new EmptyBorder(4, 4, 4, 4));

        JPanel pList = new JPanel(new GridLayout(0, 1, 3, 3));
        pList.setBorder(new TitledBorder("GridLayout"));

        for (int ii = 1; ii < 21; ii++) {
            pList.add(getShowRoomPanel(ii));
        }

        JScrollPane scrollPane = new JScrollPane(pList,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        ui.add(scrollPane);
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception useDefault) {
                }
                ShowRoomLayout o = new ShowRoomLayout();

                JFrame f = new JFrame(o.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setLocationByPlatform(true);

                f.setContentPane(o.getUI());
                f.pack();
                Dimension d = f.getSize();
                f.setSize(new Dimension(d.width, 400));
                f.setMinimumSize(f.getSize());

                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}