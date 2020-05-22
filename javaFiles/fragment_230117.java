public class ProcessRunnable implements Runnable{
    private final Queue<Item> queue = new LinkedList<Item>();
    public void run(){
        while(active){
            synchronized(queue){
                while(queue.size()>0){
                    Item item = queue.remove();
                    //process item
                }
                queue.wait();
            }
        }
    }
    public void add(Item item){
        synchronized(queue){
            this.queue.add(item);
            this.queue.notifyAll();
        }
    }
}