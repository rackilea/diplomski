public void handleTableRowOnClick(final String data) { 
    Runnable runner = new Runnable() {
        public void run() {
            InfoDialog d = new InfoDialog(data);
        }
    }
    if (EventQueue.isDispatchingThread()) {
        runner.run();
    } else {
        EventQueue.invokeLater(runner);
    }
}