public class testFrame extends JPanel {
    private JButton testButton, anotherButton;

    public testFrame() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        testButton = new JButton("New Button");
        constraints.gridx = 0; // Location on grid
        constraints.gridy = 3; // Location on grid
        constraints.gridwidth = 2; // How many grids the width will consume
        constraints.gridheight = 1; // How many grids the length will consume
        constraints.weightx = 1.0; // for resizing
        constraints.weighty = 1.0; // for resizing
        constraints.anchor = GridBagConstraints.SOUTHWEST; // Where it will be anchored
        constraints.ipadx = 20; // Internal padding
        constraints.ipady = 20; // Inernal padding
        constraints.insets = new Insets(50,50,50,50);
        add(testButton, constraints);

        anotherButton = new JButton("another Button");
        constraints.gridx = 0; // Location on grid
        constraints.gridy = 3; // Location on grid
        constraints.gridwidth = 2; // How many grids the width will consume
        constraints.gridheight = 1; // How many grids the length will consume
        constraints.weightx = 1.0; // for resizing
        constraints.weighty = 1.0; // for resizing
        constraints.anchor = GridBagConstraints.SOUTHWEST; // Where it will be anchored
        constraints.ipadx = 20; // Internal padding
        constraints.ipady = 20; // Inernal padding
        constraints.insets = new Insets(50, 50, 120, 80);
        add(anotherButton, constraints);
    }
}