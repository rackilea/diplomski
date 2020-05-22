public LinkedList<String> Add () {
    /**
     This method is used to load an array of string objects
     into a linked list
    */
    int x;
    for (x=0; x < words.length; x++) {
        list.add(x, words[x]);
    }

    return list;
}