public class Monitor extends JFrame{

    TableModel model;
    Vector<String> columnNames;
    <other components>
    public Monitor() throws SQLException {
        columnNames = dbmonitor.getColumnNames();
        model = new DefaultTableModel(columnNames, 0);
        <Add all components, including table with the created table model>
        (worker = new MySwingWorker()).execute();
    }

    private class MySwingWorker extends SwingWorker<Void, Vector<Vector>> {
         @Override
         protected Void doInBackground() throws Exception {
             dbmonitor = new DBMonitor();
             rowData = dbmonitor.getJobsData();

             while (!isCancelled()) {
                 Thread.sleep(10000);
                 publish(dbmonitor.getJobsData());
             }
             return null;
          }

          @Override
          protected void process(List<Vector<Vector>> data) {
              Vector<Vector> lastPublish = data.get(data.size() - 1);
              tableModel.setDataVector(lastPublish, columnNames);
          }
    }
}