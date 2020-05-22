private < T extends Box > void getParserAndParse(
    Registry registry, Class< T > clazz, Object box
) {
    registry.get( clazz ).parse( clazz.cast( box ) );
}
public void runTest() {
    Registry registry = new Registry();
    registry.add( BoxA.class, new ParserA() );
    registry.add( BoxB.class, new ParserB() );

    List<Box> boxes = new ArrayList< Box >();
    boxes.add( new BoxA( "Silly" ) );
    boxes.add( new BoxB( "Funny" ) );
    boxes.add( new BoxB( "Foo" ) );
    boxes.add( new BoxA( "Bar" ) );

    for ( Box box : boxes ) {
        Class< ? extends Box > clazz = box.getClass();
        getParserAndParse( registry, clazz, box ); // compiles
    }
}