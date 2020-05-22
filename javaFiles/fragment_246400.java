public static void add(String word){
    int position = hashFunction(word);
    if(array[position] == null){
        array[position] = new Node(word, null);
    }else{
        Node newHead = new Node(word, array[position]);
        array[position] = newHead;
    }
}