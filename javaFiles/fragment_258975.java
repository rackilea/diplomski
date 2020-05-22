static class LogInput extends JComponent {

    private JTextField logBase;
    private JTextField logNum;

    public LogInput() {
        JComponent logInputPanel = new JPanel();
        setLayout(new GridBagLayout());

        JLabel logLbl = new JLabel("Log");
        logBase = new JTextField(1);
        logNum = new JTextField(5);