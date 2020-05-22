private static final long serialVersionUID = 1L;

public Note() {
    createContent(); // add this line into your code.
    int x = 400;
    int y = 300;
    this.setSize(new Dimension(x, y));
    this.setTitle("Post-It Note");
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public JScrollPane createContent(){
    Color textAreaColor = new Color(248, 247, 235);
    JTextArea textArea = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setBorder(null);
    textArea.setBackground(textAreaColor);
    scrollPane.setBackground(textAreaColor);
    textArea.setMargin(new Insets(10, 15, 20, 20));
    this.add(scrollPane, BorderLayout.CENTER);
    return null;
}

public static void main(String[] args) {
    new Note();
  //  mainWindow.createContent(); comment this line...
}