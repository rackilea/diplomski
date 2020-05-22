List<Object> aValues = new ArrayList<Object>();
List<Object> bValues = new ArrayList<Object>();
while ( results.hasNext() ) {
    aValues.add( results.next().get( "A" ));
    bValues.add( results.next().get( "B" ));
}