JFrame frame = new JFrame("My frame");
        frame.setSize(500, 500);
        frame.setLocation(500, 0);

        Container pane = frame.getContentPane();
        GridBagLayout layout = new GridBagLayout();
        pane.setLayout(layout);

        JTextArea textEditor = new JTextArea();//JTextArea 1
        textEditor.setLineWrap(true);//setLineWrap(true)
        JTextArea textEditor1 = new JTextArea();//JTextArea 2
        textEditor1.setLineWrap(true);//setLineWrap(true)
        // LEFT TEXT EDITOR
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.add(textEditor);
        layout.setConstraints(leftPanel, constraints);
        pane.add(leftPanel);

        // CENTER BUTTON
        constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.NONE;
        JButton button = new JButton("Do");
        layout.setConstraints(button, constraints);
        pane.add(button);

        // RIGHT TEXT EDITOR
        constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.WHITE);
        rightPanel.add(textEditor1);
        layout.setConstraints(rightPanel, constraints);
        pane.add(rightPanel);