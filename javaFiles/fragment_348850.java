public T[] toArray(T[] inArray){
    int s = size();

    Node n = first;
    for (int i = 0; i < s; i++){
        inArray[i] = n.data;
        n = n.next;
    }

    return inArray;
}