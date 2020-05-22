class PopulateAction implements ActionListener, Observer {

    JTable tableToRefresh;
    JProgressBar progressBar;
    JButton sourceButton;
    DemoHelper helper;
    public PopulateAction(JTable tableToRefresh, JProgressBar progressBarToUpdate) {
        this.tableToRefresh = tableToRefresh;
        this.progressBar = progressBarToUpdate;
    }

    public void actionPerformed(ActionEvent e) {
        helper = DemoHelper.getDemoHelper();
        helper.addObserver(this);
        sourceButton = ((JButton) e.getSource());
        sourceButton.setEnabled(false);
        helper.insertData();
    }

    public void update(Observable o, Object arg) {
        progressBar.setValue(helper.getPercentage());
    }
}