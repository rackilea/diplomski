import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class KeyBoardLayout {

    private JComponent ui = null;

    KeyBoardLayout() {
        initUI();
    }

    public void initUI() {
        if (ui!=null) return;


        //ui = new JPanel(new GridBagLayout());
        int[] columns = new int[22];
        Arrays.fill(columns, 30);
        GridBagLayout gbl = new GridBagLayout();
        gbl.columnWidths = columns;
        ui = new JPanel(gbl);

        ui.setBorder(new EmptyBorder(4,4,4,4));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        ui.add(new JButton("1,1 (3)"), gbc);

        gbc.gridx = 3;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,1 (2)"), gbc);

        gbc.gridx = 5;
        ui.add(new JButton("3,1 (2)"), gbc);

        gbc.gridx = 7;
        ui.add(new JButton("4,1 (2)"), gbc);

        gbc.gridx = 9;
        ui.add(new JButton("5,1 (2)"), gbc);

        gbc.gridx = 11;
        ui.add(new JButton("6,1 (2)"), gbc);

        gbc.gridx = 13;
        ui.add(new JButton("7,1 (2)"), gbc);

        gbc.gridx = 15;
        gbc.gridwidth = 3;
        ui.add(new JButton("8,1 (3)"), gbc);

        gbc.gridx = 18;
        gbc.gridwidth = 4;
        ui.add(new JButton("9,1 (4)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        ui.add(new JButton("1,2 (4)"), gbc);

        gbc.gridx = 4;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,2 (2)"), gbc);

        gbc.gridx = 6;
        ui.add(new JButton("3,2 (2)"), gbc);

        gbc.gridx = 8;
        ui.add(new JButton("4,2 (2)"), gbc);

        gbc.gridx = 10;
        ui.add(new JButton("5,2 (2)"), gbc);

        gbc.gridx = 12;
        ui.add(new JButton("6,2 (2)"), gbc);

        gbc.gridx = 14;
        ui.add(new JButton("7,2 (2)"), gbc);

        gbc.gridx = 16;
        ui.add(new JButton("8,2 (2)"), gbc);

        gbc.gridx = 18;
        gbc.gridwidth = 4;
        ui.add(new JButton("9,2 (4)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 5;
        ui.add(new JButton("1,3 (5)"), gbc);

        gbc.gridx = 5;
        gbc.gridwidth = 2;
        ui.add(new JButton("2,3 (2)"), gbc);

        gbc.gridx = 7;
        ui.add(new JButton("3,3 (2)"), gbc);

        gbc.gridx = 9;
        ui.add(new JButton("4,3 (2)"), gbc);

        gbc.gridx = 11;
        ui.add(new JButton("5,3 (2)"), gbc);

        gbc.gridx = 13;
        ui.add(new JButton("6,3 (2)"), gbc);

        gbc.gridx = 15;
        ui.add(new JButton("7,3 (2)"), gbc);

        gbc.gridx = 17;
        ui.add(new JButton("8,3 (2)"), gbc);

        gbc.gridx = 19;
        gbc.gridwidth = 3;
        ui.add(new JButton("9,3 (3)"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        ui.add(new JButton("1,4 (3)"), gbc);

        gbc.gridx = 3;
        ui.add(new JButton("2,4 (3)"), gbc);

        gbc.gridx = 6;
        gbc.gridwidth = 10;
        ui.add(new JButton("3,4 (10)"), gbc);

        gbc.gridx = 16;
        gbc.gridwidth = 3;
        ui.add(new JButton("4,4 (3)"), gbc);

        gbc.gridx = 19;
        ui.add(new JButton("5,4 (3)"), gbc);
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
                KeyBoardLayout o = new KeyBoardLayout();

                JFrame f = new JFrame("Keyboard Layout");
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
}