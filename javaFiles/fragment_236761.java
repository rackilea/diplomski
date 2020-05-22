public Calculator() {

    super("Calculator");

    setSize(500, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel();
    GridBagLayout bag = new GridBagLayout();
    getContentPane().add(panel);
    panel.setLayout(bag);
    GridBagConstraints c = new GridBagConstraints();

    c.insets = new Insets(5, 5, 5, 5);
    c.fill = GridBagConstraints.HORIZONTAL;

    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0.0;
    c.weighty = 0.5;
    c.gridwidth = 3;
    panel.add(label1, c);

    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    panel.add(value1, c);

    c.gridx = 1;
    c.gridy = 1;
    panel.add(value2, c);

    c.gridx = 2;
    c.gridy = 1;
    panel.add(value3, c);

    c.gridwidth = 3;
    c.weightx = 0.0;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 3;
    panel.add(label2, c);

    c.gridwidth = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 4;
    c.insets = new Insets(5, 5, 5, 5);
    panel.add(value4, c);

    c.gridx = 1;
    c.gridy = 4;
    panel.add(value5, c);

    c.gridx = 2;
    c.gridy = 4;
    panel.add(value6, c);

    c.gridwidth = 3;
    c.weightx = 0.0;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 5;
    panel.add(label3, c);

    c.gridwidth = 1;
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridx = 0;
    c.gridy = 6;
    panel.add(value7, c);

    setVisible(true);
}