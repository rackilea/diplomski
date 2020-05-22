public Window() {
    super("Knight Quest");
}

public void display(JPanel panel) {
    setLayout(new BorderLayout());
    add(panel, BorderLayout.CENTER);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600,550);
    setLocation(525, 225);
    setVisible(true);
}