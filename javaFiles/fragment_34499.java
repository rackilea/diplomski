class LongRunningCode extends SwingWorker<Boolean, String> {
    private static final int MAX = 10;
    private static final long MILLI_SECONDS_SLEEP = 400;
    private CallBackEgGui gui;

    public LongRunningCode(CallBackEgGui gui) {
        this.gui = gui;
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        // this code is in place of the Python script
        // done within a background thread
        for (int i = 0; i < MAX; i++) {
            TimeUnit.MILLISECONDS.sleep(MILLI_SECONDS_SLEEP);

            // in the real program, the text will be from the InputStream from
            // the Python process.
            String text = "Value: " + i;  
            publish(text);  // then send the text to the GUI
        }

        // occasionally returns false
        boolean returnValue = Math.random() > 0.2;
        return returnValue;
    }

    @Override
    protected void process(List<String> chunks) {
        // this code is called on the Swing event thread
        for (String text : chunks) {
            gui.showText(text); // tell GUI to display text
        }
    }

    @Override
    protected void done() {
        // this code is called on the Swing event thread
        try {
            boolean result = get(); // get the result from the Worker thread
            gui.endProcess(result);  // tell GUI that process is done
        } catch (InterruptedException | ExecutionException e) {
            // TODO handle exception!
            e.printStackTrace();
        }
    }
}