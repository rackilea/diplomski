public class TreeNode {
     public Character value;
     public Map<Character, TreeNode> childs;
     public TreeNode() {
         childs = new HashMap<Character, TreeNode>();
     }
}