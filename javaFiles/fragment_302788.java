frame.getContentPane().setLayout(GridBagLayout());

    GridBagConstraints x = new GridBagConstraints();
    x.weightx = 1.0;
    x.weighty = 1.0;
    x.fill = GridBagConstraints.BOTH;

    JPanel commonPanel = new JPanel(new GridBagLayout());
    frame.getContentPane().add(commonPanel, x);