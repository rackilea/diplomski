public static boolean contains(Node root, int value){
    if(root == null) return false;
    else if (root.value==value) return true;
    else
        return
                contains(root.left, value) ||contains(root.right, value);
}