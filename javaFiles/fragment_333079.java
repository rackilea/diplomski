public class BinaryTreeSpliterator extends AbstractSpliterator<Node> {
    /**
     * a node that has not been traversed, but its children are only
     * traversed if contained in this.pending
     * (otherwise a different spliterator might be responsible)
     */
    private Node pendingNode;
    /** pending nodes needing full traversal */
    private ArrayDeque<Node> pending = new ArrayDeque<>();

    public BinaryTreeSpliterator(Node root) {
        super(Long.MAX_VALUE, NONNULL | IMMUTABLE);
        push(root);
    }

    private BinaryTreeSpliterator(Node pending, Node next) {
        super(Long.MAX_VALUE, NONNULL | IMMUTABLE);
        pendingNode = pending;
        if(next!=null) this.pending.offer(next);
    }
    private void push(Node n) {
        if(pendingNode == null) {
            pendingNode = n;
            if(n != null) {
                if(n.getRight()!=null) pending.offerFirst(n.getRight());
                if(n.getLeft() !=null) pending.offerFirst(n.getLeft());
            }
        }
        else pending.offerFirst(n);
    }

    @Override
     public boolean tryAdvance(Consumer<? super Node> action) {
        Node current = pendingNode;
        if(current == null) {
            current = pending.poll();
            if(current == null) return false;
            push(current.getRight());
            push(current.getLeft());
        }
        else pendingNode = null;
        action.accept(current);
        return true;
    }

    @Override
    public void forEachRemaining(Consumer<? super Node> action) {
        Node current = pendingNode;
        if(current != null) {
            pendingNode = null;
            action.accept(current);
        }
        for(;;) {
            current = pending.poll();
            if(current == null) break;
            traverseLocal(action, current);
        }
    }
    private void traverseLocal(Consumer<? super Node> action, Node current) {
        do {
            action.accept(current);
            Node child = current.getLeft();
            if(child!=null) traverseLocal(action, child);
            current = current.getRight();
        } while(current != null);
    }

    @Override
    public Spliterator<Node> trySplit() {
        Node next = pending.poll();
        if(next == null) return null;
        if(pending.isEmpty()) {
            pending.offer(next);
            next = null;
        }
        if(pendingNode==null) return next==null? null: new BinaryTreeSpliterator(next);
        Spliterator<Node> s = new BinaryTreeSpliterator(pendingNode, next);
        pendingNode = null;
        return s;
    }
}