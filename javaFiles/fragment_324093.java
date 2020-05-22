final List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6));
final ListIterator<Integer> ite = list.listIterator();
while( ite.hasNext() ) {
    if( ite.next() %2 == 0 ) {
        ite.add( 7 );
    }
    else {
        ite.remove(); //removes the last value returned by next()
    }
}