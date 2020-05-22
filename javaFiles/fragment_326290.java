class Node implements Serializable {

public String theName; //the wrapped name
public Node next;      //the next node in the sequence
public Node prev;      //the previous node in the sequence

public Node(Node p, String s, Node n){
    prev = p;
    theName = s;
    next = n;
}
public Node(String s){
    prev = this;
    theName = s;
    next = this;
}}