public class Tree<T extends Comparable<T>> {
     private class TreeNode<F extends<Comparable<F>> implements Comparable<TreeNode<F>>{
           private F f;
           ...
           public F getF(){return this.f;}
           @Override
           public int compareTo(TreeNode<F> node){
               return this.f.compareTo(node.getF());
           }
     }
     //Use TreeNode<T> here
     ...
}