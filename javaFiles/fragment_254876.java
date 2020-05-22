public class Tester {

private BlockingQueue<Ticket> q = new LinkedBlockingQueue<>();
private ArrayList<Long> list = new ArrayList<>();

public void acceptTicket(Ticket p) {
    try {
      //this is cleaner, because I don't know what logger class is doing,
      //I want to eliminate chance of deadlock and reduce time we are in lock
      synchronized (this){
        q.put(p);

        if (list.size() < 5) {
          list.add(p.getSize());
        } else {
          list.remove(0);
          list.add(p.getSize());
        }
     }
    } catch (InterruptedException ex) {
        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
    }    
}