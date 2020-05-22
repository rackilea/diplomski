/**
 * Returns a breadth-first order String of tree elements.
 * 
 * @return a String with a breadth-first order traversal of the tree
 */
public String breadthFirstOrder() {

 Queue<Node<E>> queue = new LinkedList<Node<E>>();
 String traversal = "";
 if (root == null)
     System.out.println("Empty tree");
 queue.clear();
 queue.add(root);
 while(!queue.isEmpty()){
     Node<E> node = queue.remove();
     System.out.print(node.data + " ");
     traversal += node.data + " ";
     if(node.left != null) queue.add(node.left);
     if(node.right != null) queue.add(node.right);
    }
    return traversal;
}