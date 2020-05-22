public class Main Frame extends J Frame {
private static final long serialVersionUID = 1L;
   public MainFrame(String title) {
    super(title);
    setLayout(new BorderLayout());
    JTextArea textArea = new JTextArea("test");
    textArea.setBounds(10, 10, 50, 20);
    JButton button = new JButton("Click me");
    button.setBounds(10, 20, 50, 20);
    Container c = getContentPane();
    c.add(textArea, BorderLayout.CENTER);
    c.add(button, BorderLayout.SOUTH);
}

public static void main(String args[]) {
    MainFrame frame = new MainFrame("Title");
    frame.setSize(500, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}