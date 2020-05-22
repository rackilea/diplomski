public class LinkedList2<E, T extends LinkedList2>{

    E data;
    T next;

}

public class LinkedSubclass extends LinkedList2<LinkedSubclass> {

}