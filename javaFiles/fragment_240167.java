void foo( ObjectType object ) {
    //pack object into singleton list 
    foo( List.of( object ) ); 
}
void foo( List< ObjectType > objects ) { 
    //execute logic on collection
}