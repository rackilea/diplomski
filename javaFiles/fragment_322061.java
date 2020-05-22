import java.util.PriorityQueue;

// Only node information
class Node {
  // Whatever you need for your graph
  public Node() {}
}

class PrioNode {
   public Node n;
   public int prio;
   public PrioNode(Node n, int prio) {
     this.n = n;
     this.prio = prio;
   }

   public int compareTo(PrioNode p) {
      return Integer.compare(this.prio, p.prio);
   }
}

...
...
PriorityQueue<PrioNode> q = new PriorityQueue<PrioNode>();
n = new Node();
q.add(new PrioNode(n,10));
...
// let's update the priority and re-add
q.add(new PrioNode(n,0));
// Everything is fine, because we have not changed the value
// in the queue.