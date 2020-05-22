public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                new Test();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

public static void addComponentsToPane(Container pane) {

    JButton button;
    pane.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    button = new JButton("Button 1");
    if (true) {
        c.weightx = 0.5;
    }
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    pane.add(button, c);

    button = new JButton("Button 2");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 1;
    c.gridy = 0;
    pane.add(button, c);

    button = new JButton("Button 3");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 0.5;
    c.gridx = 2;
    c.gridy = 0;
    pane.add(button, c);

    button = new JButton("Long-Named Button 4");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 50;
    c.weightx = 0.0;
    c.gridwidth = 3;
    c.gridx = 0;
    c.gridy = 1;
    pane.add(button, c);

    button = new JButton("5");
    c.fill = GridBagConstraints.HORIZONTAL;
    c.ipady = 20;
    c.weighty = 1.0;
    c.anchor = GridBagConstraints.PAGE_END;
    c.insets = new Insets(10, 0, 0, 0);
    c.gridx = 0;
    c.gridwidth = 3;
    c.gridy = 3;
    pane.add(button, c);

}

private void createAndShowGUI() {
    frame = new JFrame("GridBagLayoutDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

JFrame frame = null;

public Test() {

    createAndShowGUI();
    addComponentsToPane(frame.getContentPane());
    frame.pack();
    frame.setVisible(true);
}