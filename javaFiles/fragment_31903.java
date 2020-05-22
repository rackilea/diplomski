private void run() {
    JFrame main = createMain();
    populateMain(main.getContentPane());
    main.setVisible(true);
}

private JFrame createMain() {
    JFrame result = new JFrame();
    result.setTitle("Main");
    result.setSize(400, 300);
    result.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    return result;
}

private void populateMain(Container contentPane) {
    contentPane.setLayout(new GridLayout(1, 3));
    contentPane.add(button1());
    contentPane.add(button2());
    contentPane.add(button3());
}

private JButton button1() {
    JButton result = new JButton("button1");
    result.addActionListener(e -> displayWindow1());
    return result;
}

private void displayWindow1() {
    JFrame frame = new JFrame();
    frame.setTitle("Window 1");
    frame.setSize(400, 300);
    frame.setVisible(true);
}

private JButton button2() {
    JButton result = new JButton("button2");
    result.addActionListener(e -> displayWindow2());
    return result;
}

private void displayWindow2() {
    JFrame frame = new JFrame();
    frame.setTitle("Window 2");
    frame.setSize(400, 300);
    frame.setVisible(true);
}

private JButton button3() {
    JButton result = new JButton("button3");
    result.addActionListener(e -> displayWindow3());
    return result;
}

private void displayWindow3() {
    JFrame frame = new JFrame();
    frame.setTitle("Window 3");
    frame.setSize(400, 300);
    frame.setVisible(true);
}