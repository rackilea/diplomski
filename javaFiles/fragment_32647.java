public CostumTable() {
    // set the renderer layout to GridBagLayout
    setLayout(new GridBagLayout());
    // create the layouts label
    layoutsLbl = new JLabel("Layout");
    // create a grid bag constraints instance
    GridBagConstraints gbc = new GridBagConstraints();
    // first column
    gbc.gridx = 0;
    // first row
    gbc.gridy = 0;
    // maximum horizontal weight
    gbc.weightx = 1;
    // anchor to the top left corner
    gbc.anchor = GridBagConstraints.FIRST_LINE_START;
    // fill horizontally
    gbc.fill = GridBagConstraints.HORIZONTAL;
    // set the insets
    gbc.insets = new Insets(35, 0, 10, 0);
    // add the layouts label to the view
    add(layoutsLbl, gbc);


    //Just here to test the MousListener
    List<JLabel> testLabel = new ArrayList<>();
    for(int i = 0; i < 3; i++) {
        testLabel.add(new JLabel("TestLabel number " + i));
        gbc.gridx = 0;
        gbc.gridy = i + 1;
        add(testLabel.get(i), gbc);
    }
    //
}

public String clickCheck() {
    // revalidate the layouts label
    layoutsLbl.revalidate();
    // get the layouts label location
    System.out.println("Label location: " + layoutsLbl.getLocation());
    return null; //I dont know what you want to return
}