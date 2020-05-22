public class Tester {

private BlockingQueue<Ticket> q = new LinkedBlockingQueue<>();
private ArrayList<Long> list = new ArrayList<>();

public synchronized void acceptTicket(Ticket p) {
    try {
      q.put(p);

      if (list.size() < 5) {
        list.add(p.getSize());
      } else {
        list.remove(0);
        list.add(p.getSize());
      }
    } catch (InterruptedException ex) {
        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
    }    
}