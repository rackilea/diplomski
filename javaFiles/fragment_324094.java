final List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,4,5,6));
final List<Integer> newList = new ArrayList<Integer>(list);
final ListIterator<Integer> ite = list.listIterator();
while( ite.hasNext() ) {
    final Integer next = ite.next();
    if( next % 2 == 0 ) {
        newList.add( 7 );
    }
    else {
        newList.remove(next);
    }
}