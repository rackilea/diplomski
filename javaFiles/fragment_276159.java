public static void main(String[] args) {

    JFrame frame = new JFrame("Test");

    frame.add(new JTextArea("Hello World!"), BorderLayout.CENTER);
    frame.add(new JPanel(new GridLayout(1, 0)) {{
        add(new JButton("Copy"));
        add(new JButton("Paste"));
    }}, BorderLayout.EAST);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);

}