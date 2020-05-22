// in printList method add move = move.next inside the while loop as below
public void printList(Node move) {
    while (move != null) {
        System.out.print(move.data + "->");
        move = move.next; // ADD THIS LINE TO AVOID INFINTE LOOP
    }
}