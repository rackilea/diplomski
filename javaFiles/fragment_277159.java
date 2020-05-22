public class LogViews extends JDialog {
    private DefaultListModel logModel;
    private JList<String> logList;

    public LogViews(JFrame frame, boolean modal){
        super(frame, true);
        logModel = new DefaultListModel();
        logList = new JList();
        logList.setModel(logModel);
        JScrollPane logListScroll = new JScrollPane(logList);

        setLayout(new BorderLayout());
        add(logListScroll);
        pack();
    }
}