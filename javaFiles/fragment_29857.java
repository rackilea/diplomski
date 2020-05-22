public class GUI extends JFrame {

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setSize(600, 600);
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        SwingUtilities.invokeLater(() -> {
            gui.setVisible(true);
        });
    }

    public GUI() {
        super();

        //those should be initialized outside
        JLabel labBrawn = new JLabel("Brawn");
        JLabel labAgility = new JLabel("Agility");
        JLabel labIntellect = new JLabel("Intellect");
        JLabel labCunning = new JLabel("Cunning");
        JLabel labWillpower = new JLabel("Willpower");
        JLabel labPresence = new JLabel("Presence");

        JTextField txtBrawn = new JTextField("", 2);
        JTextField txtAgility = new JTextField("", 2);
        JTextField txtIntellect = new JTextField("", 2);
        JTextField txtCunning = new JTextField("", 2);
        JTextField txtWillpower = new JTextField("", 2);
        JTextField txtPresence = new JTextField("", 2);
        //--------------------------------------------

        //here goes actual GUI
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;

        JPanel dataInputPanel = new JPanel();
        dataInputPanel.setLayout(gridBagLayout);

        gbc.weightx = 1;
        gbc.weighty = 0;

        gbc.gridx = 0;
        gbc.gridy = 0;
        dataInputPanel.add(labBrawn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        dataInputPanel.add(labAgility, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        dataInputPanel.add(labIntellect, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        dataInputPanel.add(labCunning, gbc);

        gbc.gridx = 4;
        gbc.gridy = 0;
        dataInputPanel.add(labWillpower, gbc);

        gbc.gridx = 5;
        gbc.gridy = 0;
        dataInputPanel.add(labPresence, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        dataInputPanel.add(txtBrawn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        dataInputPanel.add(txtAgility, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        dataInputPanel.add(txtIntellect, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        dataInputPanel.add(txtCunning, gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        dataInputPanel.add(txtWillpower, gbc);

        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.weighty = 1;
        dataInputPanel.add(txtPresence, gbc);

        dataInputPanel.setBackground(Color.red);
        this.add(dataInputPanel, BorderLayout.NORTH);
    }
}