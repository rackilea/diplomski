static String min ( AVLStringTreeNode t ) {
    if( t == null )
        return null;
    while( t.left != null ) // location of error
        t = t.left;
    return t.val;
}