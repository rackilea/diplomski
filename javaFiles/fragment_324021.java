// the panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridBagLayout());
    buttonPanel.setSize(new Dimension(400, 300)); // whatever

    // the scrollpane
    JScrollPane pane = new JScrollPane();
    pane.setSize(new Dimension(400, 300)); // whatever

    // GridBagConstraint for button
    GridBagConstraints constraint = new GridBagConstraints();
    constraint.anchor = GridBagConstraints.CENTER;
    constraint.fill = GridBagConstraints.NONE;
    constraint.gridx = 0;
    constraint.gridy = GridBagConstraints.RELATIVE;
    constraint.weightx = 1.0f;
    constraint.weighty = 1.0f;

    int sizeOfButtons = 50;
    for(int i = 0; i < sizeOfButtons; i++) {
        JButton button = new JButton();

        button.setText("Button #" + i);

        // other attributes you will set

        buttonPanel.add(button, constraint);
    }

    pane.setViewportView(buttonPanel);
    this.rootPane.add(pane); // or other panel etc.
    pane.updateUI();