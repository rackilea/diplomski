...
private void runInEdt(final Runnable runnable) {
    if (SwingUtilities.isEventDispatchThread())
        runnable.run();
    else
        SwingUtilities.invokeLater(runnable);
}

public void showScreen() {
    runInEdt(new Runnable() {
        public void run() {
            setVisible(true);
        }
    });
}

public void close() {
    runInEdt(new Runnable() {
        public void run() {
            setVisible(false);
            dispose();
        }
    });
}

public void setProgress(final String message, final int progress) {
    runInEdt(new Runnable() {
        public void run() {
            progressBar.setValue(progress);
            if (message == null)
                progressBar.setStringPainted(false);
            else
                progressBar.setStringPainted(true);
            progressBar.setString("Loading " + message + "...");
        }
    });
}