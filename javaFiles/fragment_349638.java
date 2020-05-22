public class ScannerWorker extends SwingWorker<Object, String[]> implements  Consumer {

    private DefaultTableModel tableModel;

    public ScannerWorker(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    @Override
    protected Object doInBackground() throws Exception {
        Scanner scanner = new Scanner();
        scanner.getCompanyProfile(this);
        return null;
    }

    @Override
    public void publish(String company, String country, String webLink, String email) {
        publish(new String[]{company, email, webLink, country, "", ""});
    }

    @Override
    protected void process(List<String[]> chunks) {
        for (String[] rowData : chunks) {
            tableModel.addRow(rowData);
        }
    }

}