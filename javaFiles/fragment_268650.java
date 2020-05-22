public static void main(String[] args) {
    JPanel panel1 = new JPanel(new MigLayout(new LC().fill()));
    panel1.add(new JTextField("text1"), "span, growx");
    panel1.add(new JTextField("another text field"), "span, growx");
    panel1.add(new JTextField("text3"), "span, growx");

    JPanel panel2 = new JPanel(new MigLayout());
    JTextArea textArea = new JTextArea();
    textArea.setColumns(15);
    textArea.setRows(7);
    JScrollPane jsp = new JScrollPane(textArea);
    panel2.add(jsp, "span, grow");

    JFrame frame = new JFrame();
    frame.setLayout(new GridLayout(1, 2));
    frame.add(panel1);
    frame.add(panel2);

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}