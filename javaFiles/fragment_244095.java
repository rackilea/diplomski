public class MainFrame extends JFrame {
    private final JTextPane txt1 = createTextPane();
    private final JTextPane txt2 = createTextPane();
    private final JTextPane txt3 = createTextPane();

    public MainFrame() {
        JPanel panel = new JPanel();

        panel.setLayout(new CustomLayout(txt1, txt2, txt3));

        panel.add(txt1);
        panel.add(txt2);
        panel.add(txt3);

        add(new JScrollPane(panel));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(10, 10, 100, 100);
    }