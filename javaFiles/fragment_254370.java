Node root;
Node child;
Integer valueIAmTryingToInsert = 5;
if(valueIAmTryingToInsert.compareTo(root.data) < 0){
    if(root.left == null){
        root.left = new Node(valueIAmTryingToInsert);
    }
    child = root.left;
}else{
    if(root.right == null){
        root.right = new Node(valueIAmTryingToInsert);
    }
    child = root.right;
}
return true;