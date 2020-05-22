public class LinkedList {

    private Node first,last;
    private int size ;

    //adds node as last. not null safe
    public void addNode(Node node) {

        if(first == null) {
            node.setParent(null);
            first = node;
            last = node;
        }else {
            node.setParent(last);
            last = node;
        }

        size++;
    }

    public Node getFirst() {return first;}
    public Node getLast() { return last;    }
    public int getSize() {return size;}

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.addNode(new Node(0,null));
        list.addNode(new Node(1,null));
        list.addNode(new Node(2,null));
        list.addNode(new Node(3,null));

        Node node = list.getLast();
        System.out.println("list has "+ list.size + " nodes:");
        while(node != null) {
            System.out.println(node);
            node = node.getParent();
        }
    }
}

class Node{

    private int data;
    private Node parent;
    Node(int nodeData, Node parent) {
        data = nodeData;
        this.parent = parent;
    }

    public int getData() {  return data;}
    public void setData(int data) { this.data = data; }
    public Node getParent() {return parent; }
    public void setParent(Node parent) {this.parent = parent;}
    @Override
    public String toString() {return "Node "+getData() +" parent:"+ getParent();}
}