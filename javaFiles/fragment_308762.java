/* DataBuilder.java */
public class DataBuilder {
    private List _listeners = new ArrayList();
    private String data;
    public boolean submitData(String temp) {
            /* Builds the data
             * This function builds the data, as explained in the OP
             * This function fires the databuilder data event when finished
                     * building the data.
             */
        data = temp;
        fireDataBuilderEvent(data); //firing the databuilder event when finished
        return true;
    }
    public synchronized void addDataBuilderListener(DataBuilderListener listener) {
        _listeners.add(listener);
    }
    public synchronized void removeDataBuilderListener(DataBuilderListener listener) {
        _listeners.remove(listener);
    }
    private synchronized void fireDataBuilderEvent(String temp) {
        DataBuilderEvent dRE = new DataBuilderEvent(this, temp);
        Iterator listeners = _listeners.iterator();
        while(listeners.hasNext()) {
            ((DataBuilderListener)listeners.next()).dataBuilderReceived(dRE);
        }
    }
    public interface DataBuilderListener {
        public void dataBuilderReceived(DataBuilderEvent event);
    }
}