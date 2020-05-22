public static class Model extends SwingWorker<Integer, Progress> {

    private HashMap<String, Number> GUIparams;
    private int session;
    private int ticks;
    private JTextArea textArea;

    Model(HashMap<String, Number> KSMParams, JTextArea textArea) {
        GUIparams = KSMParams;
        session = (Integer)GUIparams.get("experimentsInSession");
        ticks = (Integer)GUIparams.get("howManyTicks");

        this.textArea = textArea;
    }

    @Override
    protected void process(List<Progress> progressList) {
        for (Progress p : progressList){
            textArea.append(p.getTask() + " : " + p.getElement() + "\n");
            System.out.println(p.getTask() + " : " + p.getElement());
        }
    }

    /**
     * Actual simulation
     */
    @Override
    protected Integer doInBackground() throws Exception {

        int i=0;
        while(!isCancelled() && i<session){
            i++;
            int ii=0;
            while(!isCancelled() && ii<ticks){
                // this is n, the task length and I'd like to update the GUI with this value
                ii++;
            }
            //System.out.println(i);
            // this is m, how many time the task has been repeated, and now it is updated in the GUI
            publish(new Progress(i, ii));
            //setProgress(i);
            setProgress(100 * i / session);
            Thread.sleep(1000);
        }
        return i;
    }  

    /**
     * Invoked when simulation exits
     */
    @Override
    protected void done() {
        if (isCancelled()) {
            Logger.getLogger(Model.class.getName()).log(Level.WARNING, "Experiment session cancelled by user. Closing Session...");
        } else {
            // do stuff

            Logger.getLogger(Model.class.getName()).log(Level.WARNING, "Experiment session ended.");
        }
    }
}