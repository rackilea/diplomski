public class Tree {

    private static class Node {
        Book book;
        List<Node> leaves;
        Node parent;

        public Node(Book b, Node p) {
            this.book = b;
            this.leaves = new LinkedList<>();
            this.parent = p;
        }

        @Override
        public String toString() {
            return book.toString();
        }

    }

    private Node root;

    private void swap(Node oldParent, Node newParent) {
        oldParent.leaves.add(newParent);
        newParent.parent = oldParent.parent;
        oldParent.parent = newParent;
        newParent.leaves.add(oldParent);
        oldParent.leaves.remove(newParent);
        if (newParent.parent != null) {
            newParent.parent.leaves.add(0, newParent);
            newParent.parent.leaves.remove(oldParent);
        }
        if (oldParent == root) {
            root = newParent;
            // Handle special scenario when the leaf of the root and the leaf of the the leaf
            // have the same value and then rebalance the leaves.
            if (!oldParent.leaves.isEmpty() && !newParent.leaves.isEmpty()) {
                Node n2 = oldParent.leaves.get(0); 
                Node n1 = newParent.leaves.get(0);
                if (n1.book.rating != n2.book.rating)
                    return;
                root.leaves.add(0, n2);
                n2.parent = root;
                n1.leaves.clear();
            }
        }
    }


    private void add(Node n, Book b) {
        System.out.println("@" + b.toString());
        int prevNodeRating = n.book.rating;
        if (b.rating < prevNodeRating) {
            swap(n, new Node(b, n));
        }
        else if (b.rating > prevNodeRating) {
            if (n.leaves.isEmpty()) {
                Node newNode = new Node(b, n);
                n.leaves.add(newNode);    
            } else {
                add(n.leaves.get(0), b);
                return;
            }
        } 
        else {
            if (n == root) {
                if (!n.leaves.isEmpty() &&  n.leaves.get(0).book.rating == b.rating) {
                    root.leaves.add(new Node(b, n));
                    return;
                } 
                Node newNode = new Node(b, n);
                n.leaves.add(0, newNode);   // set at first position
                Iterator<Node> itr = n.leaves.iterator();
                itr.next(); // skip first;
                while (itr.hasNext()) {
                    Node leaf = itr.next();
                    if (leaf.book.rating >= b.rating) {
                        newNode.leaves.add(leaf);
                        leaf.parent = newNode;
                        itr.remove();
                    } 
                }
            } else {
                n.parent.leaves.add(new Node(b, n.parent));
            }
        }
        System.out.println(toString() + "\n----------------");
    }

    public void add(Book b) {
        if (root == null)
            root = new Node(b, null);
        else add(root, b);
    }

    private void toStringItr(Node n, int lvl, StringBuilder sb) {
        if(n == null) return;                    
        for (int i = 0; i < 3*lvl; i++) {
           sb.append(" ");
        }
        sb.append(n.book.toString()).append("\n");
        n.leaves.forEach((leaf) -> {
            toStringItr(leaf, lvl + 1, sb);
        });

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (root == null)
            return "null";
        toStringItr(root, 0, sb);
        return sb.toString();
    }
}