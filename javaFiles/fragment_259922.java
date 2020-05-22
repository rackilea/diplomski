private void display_recurse( Pokeball current ) {
    if ( current == null )
      return;
    System.out.print( current.display() + "->" );
    display_recurse( current.next);
}