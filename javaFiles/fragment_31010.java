for ( final BinaryNode<Integer> c : children( node ) )
    {
        if ( findHeight( c ) > 1 && z <= 1 )
        {
            final BinaryNode<Integer> res = nodeCheck( c );
            if ( null != res )
                return res;
        }
    }
    return null;
}