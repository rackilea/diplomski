public static int minValue(MyNode n) {
    int root, left, right;
    int min = -1;
    if (n != null) {
        root = (int) n.obj;
        left = minValue(n.left);
        right = minValue(n.right);
        if (left > -1){
            if(right > -1){
                min = Math.min(left, right);
                min = Math.min(root, min);
            }
            else{
                min = Math.min(left, root);
            }
        }
        else{
            min = root;
        }
    }
    return min;
}