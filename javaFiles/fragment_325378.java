public class Test extends JavaFXWorker<Integer> {
    private final ObservableList<Integer> testlist;

    public Test(ObservableList<Integer> list) {
        testlist = list;
    }

    @Override
    public void run() {
        // Emulates the server communication thread. Instead of an endless loop, I used a fixed number of iterations.
        // The real application has an endless while loop for server communication so a Task cannot be used to
        // get the data

        // getDataFromServer()
        // parseData()
        // putDataInList()
        // loop
        Thread.sleep(2000);
        for (int i = 0; i < 500; ++i) {
            publish(i);
        }
    }

    @Override
    protected process(List<Integer> chunks) {
        testlist.addAll(chunks);
    }
}