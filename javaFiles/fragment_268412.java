for ( int i : a )
{
    s.push( i );
    q.add( s.pop() + 5 );
    System.out.print( s.pop() + " " );
}