// change to a void method
public void refreshTable() {
    String selection = (String) jComboBoxCollectionName.getSelectedItem();

    // SwingWorker to get collections
    GetCollectionsWorker getCollectionsWorker = new GetCollectionsWorker(selection);
    getCollectionsWorker.addPropertyChangeListener(new GetCollectionsListener());
    getCollectionsWorker.execute(); // run worker on background thread
}

// FIXME: Generic type Collections is wrong -- need to use correct type, whatever type collections is
private class GetCollectionsWorker extends SwingWorker<Collections, Void> {
    private String selection;

    public GetCollectionsWorker(String selection) {
        this.selection = selection;
    }

    @Override
    protected Collections doInBackground() throws Exception {
        // do database work here in a background thread
        return db.getCollection(selection);
    }
}

// class that listens for completion of the GetCollectionsWorker worker
class GetCollectionsListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // all this is done on the EDT
        if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
            // if worker is done, first get worker from listener
            GetCollectionsWorker worker = (GetCollectionsWorker) evt.getSource();
            try {
                // then extract the data that it's returning
                collections = worker.get();

                // then offer user option of continuing or not
                if (collections.count() > 1000) {
                    int ret = JOptionPane.showConfirmDialog(UserInterface.this,
                            "The table contains more than thousand row.\nThis may slow down the process and could cause Memory error.Are you sure to continue?",
                            "Too Large Collection (" + collections.count() + " Rows)", YES_NO_OPTION, INFORMATION_MESSAGE);
                    if (ret != YES_OPTION) {
                        return;
                    }
                }

                // our next worker, one to create table model
                CreateTableModelWorker createModelWorker = new CreateTableModelWorker(collections);
                // be notified when it is done
                createModelWorker.addPropertyChangeListener(new CreateModelListener());
                createModelWorker.execute(); // run on background thread

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

// worker to create table model on background thread
class CreateTableModelWorker extends SwingWorker<DefaultTableModel, Void> {
    private Collections collections;

    public CreateTableModelWorker(Collections collections) {
        this.collections = collections;
    }

    @Override
    protected DefaultTableModel doInBackground() throws Exception {
        documents = collections.find().into(new ArrayList<Document>());

        Set<String> colNames = new HashSet<>();

        for (Document doc : documents) {
            for (String key : doc.keySet()) {
                colNames.add(key);
            }
        }

        columns = colNames.toArray();
        Object[][] elements = new Object[documents.size()][columns.length];
        int docNo = 0;

        for (int i = 0; i < columns.length; i++) {
            if (((String) columns[i]).equalsIgnoreCase("_id")) {
                _idcol = i;
                break;
            }
        }

        for (Document doc : documents) {
            for (int i = 0; i < columns.length; i++) {
                if (doc.containsKey(columns[i])) {
                    elements[docNo][i] = doc.get(columns[i]);
                }
            }
            docNo++;
        }
        DefaultTableModel model = new DefaultTableModel(elements, columns);
        return model;
    }
}

private class CreateModelListener implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // all this is done on the EDT
        if (SwingWorker.StateValue.DONE == evt.getNewValue()) {
            // if worker is done, first get worker from listener
            CreateTableModelWorker worker = (CreateTableModelWorker) evt.getSource();
            try {
                DefaultTableModel model = worker.get();
                jTableResultTable.setModel(model);
                UserInterface.this.model = model;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}