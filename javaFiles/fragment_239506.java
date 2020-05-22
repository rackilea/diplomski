@Override
public String toString() 
{
    java.lang.StringBuilder toReturn = new java.lang.StringBuilder();  
    if (rootNode == null){
        return "";
    }
    else{
        inorder(rootNode.data , toReturn);
    }
    return toReturn.toString();
}

/** 
 * @param root
 */
public void inorder(Node<T> root , java.lang.StringBuilder treeLikeStringBuilder){
    if (root != null){
        inorder(root.left);
        System.out.println(root.value + " ");
        treeLikeStringBuilder.append( root.value.toString() + " " );
        inorder(root.right);
    }
}