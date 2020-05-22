/* DataRobot.java */
public class DataRobot {
    /* This class is for analyzing the data */
    private List _listeners = new ArrayList();
    private String data;
    public boolean analyzeData(String temp) {
        /* Analyze the data
         * This function analyzes the data, as explained in the OP
         * This function fires the analyzed data event when finished
             * analyzing the data.
         */
        data = temp;
        fireDataAnalyzedEvent(data); // this fires the dataanalyzedevent
        return true; //for now this will always return true
    }

    public synchronized void addDataAnalyzedListener(DataAnalyzedListener listener) {
        _listeners.add(listener);
    }
    public synchronized void removeDataAnalyzedListener(DataAnalyzedListener listener) {
        _listeners.remove(listener);
    }
    private synchronized void fireDataAnalyzedEvent(String temp) {
        DataAnalyzedEvent dRE = new DataAnalyzedEvent(this, temp);
        Iterator listeners = _listeners.iterator();
        while(listeners.hasNext()) {
            ((DataAnalyzedListener)listeners.next()).dataAnalyzedReceived(dRE);
        }
    }
    public interface DataAnalyzedListener {
        public void dataAnalyzedReceived(DataAnalyzedEvent event);
    }
}