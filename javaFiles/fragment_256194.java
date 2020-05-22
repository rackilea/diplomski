import java.util.Iterator;

public class BST<T extends Comparable<T>> implements Iterable<T> {
    private Node root;

    public BST(){
        root=null;
    }

    private void insertInternal(T value, Node parent) {
        int comp=value.compareTo(parent.data);
        if(comp < 0) {
            if(parent.left == null) {
                parent.left = new Node(value);
            }
            else {
                insertInternal(value, parent.left);
            }
        }
        else if(comp > 0) {
            if(parent.right == null) {
                parent.right = new Node(value);
            }
            else {
                insertInternal(value, parent.right);
            }
        }
    }

    public void insert(T value) {
        if(root == null) {
            root = new Node(value);
            return;
        }
        insertInternal(value, root);
    }

    private Node searchInternal(T target, Node node) {
        if(node == null) {
            return null;
        }
        int comp=target.compareTo(node.data);
        if(comp < 0) {
            return searchInternal(target, node.left);
        }
        else if(comp > 0) {
            return searchInternal(target, node.right);
        }
        return node;
    }

    public Node search(T target) {
        return searchInternal(target, root);
    }

    private class Node {
        T data;
        Node left, right;

        public Node(T t) {
            data=t;
        }
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<Integer>();
        bst.insert(2);
        bst.insert(6);
        System.out.println(bst.search(2) != null);
        System.out.println(bst.search(6) != null);
        System.out.println(bst.search(8) == null);
    }
}