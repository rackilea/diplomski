public Zadatak2() {

    JPanel panel1 = new JPanel();
    setSize(500, 250);
    setLocationRelativeTo(null);
    add(panel1);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);

    BorderLayout border1 = new BorderLayout();
    panel1.setLayout(border1);

    JPanel panel2 = new JPanel();
    GridBagLayout grid1 = new GridBagLayout();

    panel2.setLayout(grid1);
    panel2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    Insets insets = new Insets(2, 2, 2, 2);

    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Bold"), c);

    c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 0;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Strikerthrough"), c);

    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 1;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Italic"), c);

    c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 1;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Teletype"), c);

    c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 2;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Underline"), c);

    c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 2;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Emphasis"), c);

    c = new GridBagConstraints();
    c.gridx = 1;
    c.gridy = 3;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JCheckBox("Strong"), c);

    insets = new Insets(2, 40, 2, 2);
    c = new GridBagConstraints();
    c.gridx = 2;
    c.gridy = 0;
    c.insets = insets;
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JLabel("Sample text"), c);

    c = new GridBagConstraints();
    c.gridx = 2;
    c.gridy = 1;
    c.insets = insets;
    c.weightx = .5;
    c.fill = GridBagConstraints.BOTH;
    c.gridheight = 3;
    JTextArea ta = new JTextArea("Sample text", 4, 4);
    JScrollPane sp = new JScrollPane(ta);
    panel2.add(sp, c);

    c = new GridBagConstraints();
    c.gridx = 2;
    c.gridy = 5;
    c.insets = new Insets(40, 40, 2,2);
    c.anchor = GridBagConstraints.WEST;
    panel2.add(new JButton("Apply"), c);


    panel1.add(panel2, BorderLayout.CENTER);

    pack();

    setVisible(true);
}