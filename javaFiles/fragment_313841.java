public static SinglyLinkedList<String> concatenate (SinglyLinkedList<String>game1, SinglyLinkedList<String>game2) {
    SinglyLinkedList<String> result;
    SinglyLinkedList<String> temp;
    try {
        result = game1.clone(); // game1 copied into result
        temp = game2.clone(); // get copy of second list, which we will destroy in the process of concatenation
    }
    catch(CloneNotSupportedException e) { // can only happen if it was not implemented
        return null; 
    }
    while(!temp.isEmpty()) {
        result.addLast(temp.removeFirst());
    }

    return result;
}