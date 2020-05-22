@SuppressWarnings("serial")
class StartThreadAction extends AbstractAction {
    private CallBackEgGui gui;
    private LongRunningCode longRunningCode;

    public StartThreadAction(CallBackEgGui gui) {
        super("Start Long Running Code");
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        longRunningCode = new LongRunningCode(gui);
        longRunningCode.execute(); // start the SwingWorker

        // order is important since the method below shows the modal dialog
        // and thus blocks any code flow below it. So execute the worker FIRST
        // before calling this blocking code
        gui.startProcess(); 
    }
}