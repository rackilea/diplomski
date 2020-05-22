private void addComponentsToPane() {
    JPanel panel = new JPanel();
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    setContentPane(panel);
    setLayout(new BorderLayout());

    Border border = BorderFactory.createLineBorder(Color.BLACK);

//  inputField.addKeyListener(new ConsoleKeyListener());

    console.setEditable(false);

    JScrollPane consoleScrollPane = new JScrollPane(console);

    console.setBackground(new Color(230, 230, 250));
    console.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
    console.setFont(font);

    inputField.setFont(font);

    getContentPane().add(inputField, BorderLayout.SOUTH);
    getContentPane().add(consoleScrollPane);
//  getContentPane().add(console);

    Insets insets1 = getContentPane().getInsets();
//  console.setBounds(10 + insets1.left, 10 + insets1.top, 800 - 20, 600 - 65);
//  inputField.setBounds(7 + insets1.left, (600 - 70) + 20 + insets1.top, 800 - 14, 20);
  }