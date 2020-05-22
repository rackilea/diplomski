class Task extends SwingWorker<Void, String> {

    protected   static final String INDETERMINATE_ON = "indeterminate.on";
    protected   static final String INDETERMINATE_OFF = "indeterminate.off";

    private FileManager fileMgr;

    public Task(String srcPath) {
        this.fileMgr = new FileManager(new File(srcPath));

    }

    @Override
    protected void process(List<String> chunks) {
        for (String text : chunks) {
            if (INDETERMINATE_OFF.equals(text)) {
                progressBar.setIndeterminate(false);
            } else if (INDETERMINATE_ON.equals(text)) {
                progressBar.setIndeterminate(true);
            } else {
                progressBar.setString(text);
            }
        }
    }

    /*
         * Main task. Executed in background thread.
     */
    @Override
    public Void doInBackground() {
        try {
            publish(INDETERMINATE_ON);
            fileMgr.readFiles();
            publish(INDETERMINATE_OFF);
            convertToXLS(fileMgr, new ProgressListener() {
                @Override
                public void progressChanged(double progress) {
                    setProgress((int) (progress * 100d));
                }

                @Override
                public void setStatus(String text) {
                    publish(text);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
         * Executed in event dispatching thread
     */
    @Override
    public void done() {
        Toolkit.getDefaultToolkit().beep();
        try {
            progressBar.setString("FileRead Successful");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}//end of task class