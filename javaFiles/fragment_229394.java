this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setPreferredSize(new Dimension(1080, 720));

    this.setLayout(new GridBagLayout());
    GridBagConstraints constraints;

    JLabel a = new JLabel();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx=0.25;
    constraints.insets = new Insets(4,4,4,4);
    this.add(a,constraints);

    JLabel b = new JLabel();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 1;
    constraints.gridy = 0;
    constraints.weightx=0.25;
    this.add(b,constraints);

    JLabel c = new JLabel();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 2;
    constraints.gridy = 0;
    constraints.weightx=0.5;
    constraints.insets = new Insets(4,4,4,4);
    this.add(c,constraints);

    JLabel d = new JLabel();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 3;
    constraints.gridy = 0;
    constraints.weightx=0;
    this.add(d,constraints);

    JLabel p1 = new JLabel("Project - 1");
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth=2;
    constraints.insets = new Insets(4,4,4,4);
    this.add(p1,constraints);

    JLabel p2 = new JLabel("Project - 2");
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 2;
    constraints.gridy = 0;
    constraints.gridwidth=2;
    constraints.insets = new Insets(4,4,4,4);
    this.add(p2,constraints);


    JScrollPane projectScrollPane = new JScrollPane();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 2;
    constraints.weighty=1;
    constraints.insets = new Insets(4,4,4,4);
    this.add(projectScrollPane,constraints);

    JScrollPane fieldScrollPane = new JScrollPane();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 2;
    constraints.gridy = 1;
    constraints.gridwidth = 2;
    constraints.insets = new Insets(4,4,4,4);
    fieldScrollPane.setPreferredSize(new Dimension(540, 240));
    this.add(fieldScrollPane,constraints);

    JTextField searchTextField = new JTextField();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 3;
    constraints.insets = new Insets(4,4,4,4);
    searchTextField.setPreferredSize(new Dimension(1000,30));
    this.add(searchTextField,constraints);

   JButton searchButton = new JButton("Search");
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.NONE;
    constraints.anchor = GridBagConstraints.LINE_END;
    constraints.gridx = 3;
    constraints.gridy = 2;
    constraints.insets = new Insets(4,4,4,4);
    searchButton.setSize(new Dimension(80,30));
    this.add(searchButton,constraints);

    JScrollPane imageScrollPane = new JScrollPane();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.insets = new Insets(4,4,4,4);
    constraints.weighty=1;
    this.add(imageScrollPane,constraints);

    JScrollPane imagePane = new JScrollPane();
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = 1;
    constraints.gridy = 3;
    constraints.gridwidth = 3;
    constraints.weighty=1;
    constraints.insets = new Insets(4,4,4,4);
    this.add(imagePane,constraints);

    this.pack();