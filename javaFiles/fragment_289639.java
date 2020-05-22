tabbedPane.addChangeListener(new ChangeListener() {
private boolean init;

public void stateChanged(ChangeEvent e) {
    if (!init) {                                        
        init = true;

        new SwingWorker<Boolean, Void>() {
            @Override
            protected void done() {
                try {
                    boolean loggedIn = get();

                    if (loggedIn) {
                        // Success so perform tab operations.
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace(); // Handle this.
                } catch (ExecutionException e1) {
                    e1.printStackTrace(); // Handle this.
                }
            }

            protected Boolean doInBackground() throws Exception {
                // Perform login on background thread.  Return true if successful.
                return true;
            }
        }.execute();
    }
    }
});