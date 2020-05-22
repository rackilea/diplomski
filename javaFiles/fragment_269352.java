private void doneEDT() {
    Runnable doDone =
        new Runnable() {
            public void run() {
                done(); // <-----
            }
        };
    if (SwingUtilities.isEventDispatchThread()) {
        doDone.run(); // <-----
    } else {
        doSubmit.add(doDone);
    }
}