/**
 * Constructor Node. 
 * Creates a node with it's leafs being null.
 * @param map 
 */
public Node(Map map){
    this(map, new Node(), new Node());
}