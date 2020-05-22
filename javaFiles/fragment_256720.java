final BlockingQueue<Map.Entry>queue = new LinkedBlockingQueue<Map.Entry>();

//This is your second run
public void run(){
    while(!Thread.currentThread().isInterrupted()){
        Map.Entry current = queue.take(); //suspend here if the queue is empty until it 1 or more elements
        //use current
    }
}