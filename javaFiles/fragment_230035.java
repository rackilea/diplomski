public int height ()
{
    TNode cur = root;
    int depth = -1;

    while ( cur != null )
    {
        cur = cur.getChild( 0 );
        depth++;
    }

    return depth;
}