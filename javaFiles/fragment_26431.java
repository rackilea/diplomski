@Override
    protected Object doInBackground() throws Exception {
        NewJFrame1.progressBar.setValue(progress);
        NewJFrame1.status.setValue(stat);
        return null;
    }