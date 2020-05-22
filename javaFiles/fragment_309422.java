private Node put(Node i, Key key, Value value) {
    if (i == null) return new Node(key, value, 1);

//      int compare = key.compareTo(i.key);
//      if (compare < 0) i.left = put(i.left, key, value);
//      else if(compare > 0) i.right = put(i.right, key, value);
//      else i.value = value;
//      
//      //update N while unwinding stack
//      i.N = size(i.left) + size(i.right) + 1;
    int compare = key.compareTo(i.key);
    if (compare < 0) {
        if (i.left == null) i.left = new Node(key, value, 1);
        else put(i.left, key, value);
    }
    if (compare >= 0) {
        if (i.right == null) i.right = new Node(key, value, 1);
        else put(i.right, key, value);
    }       
    return i;
}



    //main
    BST<String, Integer> bst = new BST<>();
    String[] s = {"S", "S", "E", "E", "X", "A", "R", "C", "H", "M"};
    for (int i = 0; i < s.length; i++) {
        bst.put(s[i], i);   
    }   
    for(String key: bst.keys()) System.out.print(key + " "); // levelordered