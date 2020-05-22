public class MySwingWorker extends SwingWorker<Void, Void> {

    /**
     * The frame which must have the default cursor set 
     * at the end of the background task
     */
    private JFrame gui;

    public MySwingWorker(JFrame gui) {
        this.gui = gui;
    }

    // ...

    @Override
    protected void done() {
        // the done method is called in the EDT. 
        // No need for SwingUtilities.invokeLater here
        gui.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}