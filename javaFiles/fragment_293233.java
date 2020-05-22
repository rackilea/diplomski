JFrame window = new JFrame();

    window.setLayout(new GridBagLayout());

    JPanel top = new JPanel(), middle = new JPanel(), bottom = new JPanel();
    top.setBackground(Color.red);
    middle.setBackground(Color.green);
    bottom.setBackground(Color.blue);

    GridBagConstraints c = new GridBagConstraints();
    // we want the layout to stretch the components in both directions
    c.fill = GridBagConstraints.BOTH;
    // if the total X weight is 0, then it won't stretch horizontally.
    // It doesn't matter what the weight actually is, as long as it's not 0,
    // because the grid is only one component wide
    c.weightx = 1; 

    // Vertical space is divided in proportion to the Y weights of the components
    c.weighty = 0.2;
    c.gridy = 0;
    window.add(top, c);
    // It's fine to reuse the constraints object; add makes a copy.
    c.weighty = 0.6;
    c.gridy = 1;
    window.add(middle, c);
    c.weighty = 0.2;
    c.gridy = 2;
    window.add(bottom, c);


    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);