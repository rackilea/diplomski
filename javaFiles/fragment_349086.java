SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

    // Following code is performed in a background thread

    @Override
    protected Void doInBackground() throws Exception {

        String[] words = string.split(System.lineSeparator());
        int totalWords = words.length;

        for (int count = 0; count < totalWords; count++) {
            int progress = (count + 1) * 100 / totalWords;
            setProgress(progress);
        }
        return null;
    }
};

worker.addPropertyChangeListener(new PropertyChangeListener() {

    // Following code is performed in the EDT, as all event handling code is.
    // Progress bar update must be done here, NOT within doInBackground()

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            Integer progress = (Integer)evt.getNewValue();
            progressBar.setValue(progress); 
        }
    }
});