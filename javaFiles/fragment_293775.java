public class BinaryNode {
    public static BinaryNode bstFactory( int data, int depth ) {
        if ( depth >= 31 )
            throw new IllegalArgumentException( "too deep for integer data" );
        else if ( depth < 0 )
            throw new IllegalArgumentException( "non-sensical depth" );
        return ( depth == 0 )
            ? null
            : new BinaryNode(
                data,
                bstFactory( data - ( 1 << depth ), depth - 1 ),
                bstFactory( data + ( 1 << depth ), depth - 1 )
            );
    }
    BinaryNode( int data, BinaryNode left, BinaryNode right ) { /*...*/ }
}