public class ScrollPaneTest extends JFrame {
    private Container myCP; 
    private JTextArea resultsTA;
    private JScrollPane scrollPane;

    public ScrollPaneTest() {
        setSize(500, 500);
        setLocation(100, 100);
        myCP = this.getContentPane();
        myCP.setLayout(null);

        resultsTA = new JTextArea("Blah blah");
        resultsTA.setBounds(10, 10, 150, 30);

        scrollPane = new JScrollPane(resultsTA,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setBounds(0, 0, 500, 500);

        myCP.add(scrollPane);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ScrollPaneTest();
    }
}