public static int preOrderNumbering(MyNode n, int count){
    if(n != null){
        n.obj = ++count;

        count = preOrderNumbering(n.left, count);
        count = preOrderNumbering(n.right, count);

    }
    return count;
}