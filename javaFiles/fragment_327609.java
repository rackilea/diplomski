@Override
protected void process(List<Integer> chunks) {
    int percentCompleted = chunks.get(chunks.size() - 1); // only interested in the last value reported each time
    progressBar.setValue(percentCompleted);

    if (percentCompleted > 0) {
        progressBar.setIndeterminate(false);
        progressBar.setString(null);
    }
    System.out.println("..." + percentCompleted + "% completed");
}

/**
 * Invoked when a progress property of "downloading" is received.
 */
@Override
public void propertyChange(PropertyChangeEvent evt) {
    if (evt.getPropertyName().equals("downloading")) {
        publish((Integer) evt.getNewValue());
    }
}