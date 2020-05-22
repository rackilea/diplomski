public class Node{
   String nodeName;

   Node left;
   Node right;

   public Node(String nodeName, Node left, Node right){
     this.nodeName = nodeName;
     this.left     = left;
     this.right= right;
   }
}