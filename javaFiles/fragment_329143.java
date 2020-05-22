public class IterationSearch {
    public Node search(Graph g, Node n, GraphIterator iter){
        Node current = null;
        while (iter.hasNext()){
            current = iter.next();
            if (current.equals(n)){
                return n;
            }
        }
        return null;
    }
}