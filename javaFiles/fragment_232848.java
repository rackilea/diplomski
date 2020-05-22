public class BackgroundThread extends SwingWorker<Void, Void>
{
    private JTable table;

    public BackgroundThread(JTable table)
    {
        this.table = table;
    }

    @Override
    public Void doInBackground() throws Exception
    {
        /*
            If getJTableData() or processData() are not static,
            pass a reference of your class which has these methods
            and call them via that reference
        */
        Object[][] data = getJTableData(table);
        publish("Processing Data. . .");
        processData(data);
        publish("Data Processed. . .");
        return null;
    }

    @Override
    public void process(List<String> chunks)
    {
        for(String chunk : chunks) progressLabel.setText(chunk);
    }
}