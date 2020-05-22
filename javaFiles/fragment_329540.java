protected void addComponent(int axis, int direction, int insetOne, int insetTwo, int insetThree, int insetFour, 
                            int gridX, int gridY, int gridWidth, JComponent component) {

    GridBagConstraints bc = new GridBagConstraints();

    bc.fill = axis;
    bc.anchor = direction;
    bc.insets = new Insets(insetOne, insetTwo, insetThree, insetFour);
    bc.gridx = gridX;
    bc.gridy = gridY;
    bc.gridwidth = gridWidth;

    this.add(component, bc);
}

...
GridBagLayout gridbag = new GridBagLayout();
this.setLayout(gridbag);

addComponent(GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, 0, 10, 10, 0, 0, 0, 1, new JLabel("Hello"));
addComponent(GridBagConstraints.HORIZONTAL, GridBagConstraints.WEST, 0, 10, 10, 0, 0, 1, 1, new JButton("World"));
...