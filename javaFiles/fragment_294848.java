public class Example {

    @SuppressWarnings("serial")
    private static void initialize() {

        JFrame frmLoganalyzer = new JFrame();
        frmLoganalyzer.setTitle("LogAnalyzer");
        frmLoganalyzer.setBounds(100, 100, 450, 300);
        frmLoganalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        frmLoganalyzer.getContentPane().add(tabbedPane);

        JPanel systemLogTab = new JPanel();
        tabbedPane.addTab("System Log", null, systemLogTab, null);

        systemLogTab.setLayout(new BorderLayout());

        JList list = new JList();
        JScrollPane listScroller = new JScrollPane(list);
        systemLogTab.add(listScroller);

        frmLoganalyzer.setVisible(true);
    }

    private static void initialize2() {

        JFrame frmLoganalyzer = new JFrame();
        frmLoganalyzer.setTitle("LogAnalyzer");
        frmLoganalyzer.setBounds(100, 100, 450, 300);
        frmLoganalyzer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        frmLoganalyzer.getContentPane().add(tabbedPane);

        addTab("System Log", tabbedPane);
        frmLoganalyzer.setVisible(true);
    }

    public static void addTab(String tabName, JTabbedPane tabbedPane) {

        JPanel systemLogTab = new JPanel();
        tabbedPane.addTab(tabName, null, systemLogTab, null);
        systemLogTab.setLayout(new BorderLayout());

        JList list = new JList();
        JScrollPane listScroller = new JScrollPane(list);
        systemLogTab.add(listScroller);
    }

    public static void main(String[] args) {

        initialize(); // call initialize2() and see that it's the same
    }
}