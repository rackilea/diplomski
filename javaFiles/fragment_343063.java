public class SSCCE extends JFrame {

JTextPane pane;
JScrollPane scrollPane;
JTextField feild;

public SSCCE() throws BadLocationException {
    setSize(300, 200);
    feild = new JTextField("This is a text feild");
    // Run the program then uncomment the next line and run the program
    // again.
    add(feild, BorderLayout.NORTH);
    pane = new JTextPane();
    pane.setFocusable(true);
    pane.setText("This is some text. I am making an SSCCE. This is some additional text.");
    pane.getHighlighter().addHighlight(2, 30,
            new DefaultHighlighter.DefaultHighlightPainter(Color.LIGHT_GRAY));
    scrollPane = new JScrollPane(pane);
    add(scrollPane, BorderLayout.CENTER);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);

}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            try {
                new SSCCE();
            } catch (BadLocationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });
}
}