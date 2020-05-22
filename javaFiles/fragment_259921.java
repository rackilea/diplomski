public void display() {
    Pokeball current = this; //Note that this won't change your 'this'
    while ( current != null ) {
        System.out.print( current.display() + "->" );
        current = current.next;
    }
}