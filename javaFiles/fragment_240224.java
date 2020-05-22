public static void main( String[] args ) {
    List<Heading> myList = new ArrayList<Heading>();
    myList.add( new Heading( "desc1" ) );
    myList.add( new Heading( "desc2" ) );
    myList.add( new Heading( "desc1" ) );

    Map<String, List<Heading>> result = sameDescs( myList );

    for( Map.Entry<String, List<Heading>> e : result.entrySet() ) {
        System.out.println( e.getKey() + ":" + e.getValue().size() );
    }
}