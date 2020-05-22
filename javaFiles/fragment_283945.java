// background thread handles listening to the Scanner 
// which scans a Socket's InputStream
class MyWorker extends SwingWorker<Void, Void> {
    public static final String LINE = "line";
    private Scanner inputScanner;
    private SimpleGui gui;
    private String line = "";

    public MyWorker(Scanner inputScanner, SimpleGui gui) {
        this.inputScanner = inputScanner;
        this.gui = gui;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (inputScanner.hasNext()) {
            // get line from Scanner                
            // use the setter method in case we want to use a PropertyChangeListener later
            setLine(inputScanner.nextLine());

            // send line to the GUI
            gui.sendLine(getLine());
        }
        return null;
    }

    public String getLine() {
        return line;
    }

    // again rigged up to allow use of PropertyChangeListeners
    public void setLine(String line) {
        this.line = line;
        firePropertyChange(LINE, null, line);
    }
}