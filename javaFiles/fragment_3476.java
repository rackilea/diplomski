public class YourTaskSwingWorkerSwingWorker extends SwingWorker<List<Object>, Void> {
    private List<Object> list
    public YourClassSwingWorker(List<Object> theOriginalList){
        list = theOriginalList;
    }

    @Override
    public List<Object> doInBackground() {
        // Do the first opperation on the list
        // Do the second opperation on the list

        return list;
    }

    @Override
    public void done() {
        // Update the GUI with the updated list.
    }
}