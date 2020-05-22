public class LogViews extends JPanel
    private DefaultListModel logModel;
    private JList<String> logList;

    public LogViews(){
        logModel = new DefaultListModel();
        logList = new JList();
        logList.setModel(logModel);
        JScrollPane logListScroll = new JScrollPane(logList);

        setLayout(new BorderLayout());
        add(logListScroll);
    }

    public void addToList(String element) {
        logModel.addElement(element);
    }

    public void setLogModel(DefaultListModel model) {
        logList.setModel(model);
    }
}