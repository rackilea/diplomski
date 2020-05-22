public class Tester {

private final Object lockObj = new Object(); //specific object for locking
                                //could use any other private, non-exposed final but
                                //this makes it absolutely clear what I should be
                                //using for locks
private BlockingQueue<Ticket> q = new LinkedBlockingQueue<>();
private ArrayList<Long> list = new ArrayList<>();

public void acceptTicket(Ticket p) {
    try {
      //"this" can be locked by external code outside my control here,
      //so I use a specific private final object lockObj to eliminate deadlocks and
      //provide finer grained locking - reducing contension
      synchronized (lockObj){
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