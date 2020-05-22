// in main 
list.head = list.insertNode(1, list.head);
list.head = list.insertNode(2, list.head);
list.head = list.insertNode(3, list.head);

// in insertNode method return the move node back to caller
public Node insertNode(int value, Node move) {
    Node temp = new Node(value);
    temp.next = move;
    move = temp;
    return move;
}