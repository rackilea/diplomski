JPanel optionsPanel = new JPanel();

    JLabel label1 = new JLabel("This is label 1");
    JLabel label2 = new JLabel("This is another label");
    SpinnerModel spinnerModel1 = new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1);
    SpinnerModel spinnerModel2 = new SpinnerNumberModel(-1, -1, Integer.MAX_VALUE, 1);
    JSpinner spinner1 = new JSpinner(spinnerModel1);
    JSpinner spinner2 = new JSpinner(spinnerModel2);

    JPanel gridPanel = new JPanel();
    gridPanel.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.anchor = GridBagConstraints.LINE_START;

    c.gridx = 0;
    c.gridy = 0;
    gridPanel.add(label1, c);
    c.gridx = 0;
    c.gridy = 1;
    gridPanel.add(label2, c);
    c.gridx = 1;
    c.gridy = 0;
    gridPanel.add(spinner1, c);
    c.gridx = 1;
    c.gridy = 1;
    gridPanel.add(spinner2, c);

    optionsPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
    optionsPanel.add(gridPanel);