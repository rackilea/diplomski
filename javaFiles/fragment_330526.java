SwingWorker<Void, Vector> worker = new SwingWorker<Void, Vector>() {
    @Override
    protected Void doInBackground() {
        int numberOfFiles = files.size(); // or files.length if it's an array
        int processed = 0;
        for (File file : files) {
            ...
            // process each file here and then publish interim results
            publish(vector);
            ...
            int progress = (int)(++processed * 100 / numberOfFiles);
            setProgress(progress);
        }
        return null;
    }

    @Override
    protected void process(List<Vector> rows) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for (Vector row: rows) {
            model.addRow(row);
        }
     }
};