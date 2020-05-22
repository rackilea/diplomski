import java.util.PriorityQueue;

// Store node information and priority together
class Node implements Comparable<Node> {
  public int prio;
  public Node(int prio) { this.prio = prio; }

  public int compareTo(Node n) {
     return Integer.compare(this.prio, n.prio);
  }
}

...
...
PriorityQueue<Node> q = new PriorityQueue<Node>();
n = new Node(10);
q.add(n)
...
// let's update the priority
n.prio = 0;
// re-add
q.add(n);
// q may be broken now