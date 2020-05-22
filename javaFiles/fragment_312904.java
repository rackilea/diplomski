public class SampleModel implements Runnable{

    // Listen to this list
    public ObservableList<ToDo> toDoList = FXCollections.observableArrayList();

    // Buffer to be used to store new elements until the thread wakes up
    private BlockingQueue<ToDo> queue = new ArrayBlockingQueue<ToDo>(1000);

    @Override
    public void run() { 
        while(true){
            // Drain the buffer to the ObservableList
            queue.drainTo(toDoList);

            // Sleep a bit
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } 
        }

    public void updateBuffer(ToDo newItem){
        queue.offer(newItem);
    }
}