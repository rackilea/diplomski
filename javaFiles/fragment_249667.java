public void findWords(String prefix, Node node) { 

    if(node == null) return; 

    if(node.isWord) // Check here
        System.out.println(prefix);

    //searches through the branches of the node
    // R is 26(the branches from each node on the trie)
    // each one being a letter of the alphabet.
    for(int i = 0; i < R; i++) {  
        if(node.next[i] != null) {
            // append next character to prefix
            findWords(prefix + ('a' + i), node.next[i]);  
        }  
    }  
}