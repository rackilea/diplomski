public void runBlockingTask(final String taskName, final BlockingTask bt) {
    SwingUtilities.invokeLater(new Runnable() { public void run() {
        new Thread("Worker Thread: " + taskName) {
            @Override
            public void run() {
                bt.run();
                progressDialog.setVisible(false);
            }
        }.start();
    }});
    // NB This causes the event dispatch loop to be run inside this call,
    // which is why we need  to put everything after setVisible into an
    // invokeLater.
    progressDialog.setVisible(true);
}