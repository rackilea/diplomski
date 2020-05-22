JPanel threeCont = new JPanel(new GridBagLayout());
threeCont.add(new JLabel("3"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
        GridBagConstraints.WEST, GridBagConstraints.NONE, INSETS_0PX, 0, 0));
// We add myPanel and two(JLabel) to topPanel first and than the below.
topPanel.add(threeCont, new GridBagConstraints(
    2, 0, 1, 1, 0.45, 0.0, GridBagConstraints.EAST,
    GridBagConstraints.HORIZONTAL, INSETS_0PX, 0, 0));