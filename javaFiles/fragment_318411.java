public class Trie {

private class Node{
    private Map<Character, Node> children;
    boolean end;

    public Node(){
        children = new HashMap<>();
        end = false;
    }
}

private Node root;

public Trie(){
    root = new Node();
}

public void insert(String word){
    Node current = root;
    for (int i=0; i < word.length(); i++){
        char c = word.charAt(i);
        Node node = current.children.get(c);
        if(node == null){
            node = new Node();
            current.children.put(c, node);
        }
        current = node;
    }
    // Set end to true
    current.end = true;
}

public boolean search(String word){
    Node current = root;
    for(int i =0; i < word.length(); i++){
        char c = word.charAt(i);
        Node node = current.children.get(c);
        if(node == null)
            return false;
        current = node;
    }
    return current.end;
}


private List<String> getAll(String prefix, Node node) {
    List<String> r = new ArrayList<>();
    if (node.end) {
        r.add(prefix);
    }
    for (Map.Entry<Character, Node> child : node.children.entrySet()) {
        List<String> subSuffix = getAll(prefix + child.getKey(), child.getValue());
        r.addAll(subSuffix);
    }
    return r;
}

public List<String> returnAllChildren(String str){
    List<String> r = new ArrayList<>();
    Node current = root;
    for (int i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        Node node = current.children.get(c);
        if (node == null) {
            // Not found
            return r;
        }
        current = node;
    }
    // If you don't need the prefix, you can just
    // return getAll("", current);
    return getAll(str, current);
}

public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("abc");
    trie.insert("abcd");
    trie.insert("ab");

    List<String> r = trie.returnAllChildren("a");
    for (String s : r) {
        System.out.println(s);
    }
}
}