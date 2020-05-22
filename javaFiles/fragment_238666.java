public static class MyDBWorker extends SwingWorker<Void, Object[]> {

    private JTable table;
    private DefaultTableModel model;
    private ResultSet resultado;

    public MyDBWorker(JTable table, ResultSet resultado) {
        this.table = table;
        this.resultado = resultado;
    }

    @Override
    protected Void doInBackground() throws Exception {
        ResultSetMetaData metadata = resultado.getMetaData();
        int columnas = metadata.getColumnCount();
        Object[] etiquetas = new Object[columnas];
        for (int i = 0; i < columnas; i++) {
            etiquetas[i] = metadata.getColumnName(i + 1);
        }
        publish(etiquetas);
        while (resultado.next() && !this.isCancelled()) {
            Object fila[] = new Object[columnas];
            for (int i = 0; i < columnas; i++) {
                fila[i] = resultado.getObject(i + 1);
            }
            publish(fila);
        }
        return null;
    }


    @Override
    protected void process(List<Object[]> chunks) {
        int startIndex = 0;
        // first chunk, set up a new model
        if (model == null) {
            model = new DefaultTableModel();
            model.setColumnIdentifiers(chunks.get(0));
            table.setModel(model);
            startIndex = 1;
        }
        for (int i = startIndex; i < chunks.size(); i++) {
            model.addRow(chunks.get(i));
        }
    }

    @Override
    protected void done() {
        // nothing to do, we were cancelled
        if (isCancelled()) return;
        // check for errors thrown in doInBackground
        try {
            get();
            // all was well in the background thread
            // check if there are any results
            if (table.getModel().getRowCount() == 0) {
                // show message
            }
        } catch (ExecutionException e) {
            // we get here if f.i. an SQLException is thrown
            // handle it as appropriate, f.i. inform user/logging system
        } catch (InterruptedException e) {
            // 
        }
    }

}

// use it
SwingWorker worker = new MyDBWorker(table, resultado);
PropertyChangeListener stateListener = new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getNewValue() == SwingWorker.StateValue.STARTED) {
            progressBar.setIndeterminate(true);
        }
        if (e.getNewValue() == SwingWorker.StateValue.DONE) {
            progressBar.setIndeterminate(false);
        }

    }

};
worker.addPropertyChangeListener(doneListener);
worker.execute();