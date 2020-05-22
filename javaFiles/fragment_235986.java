...
protected Object1 object2ToObject1(Object2 object2) {
    if ( object2 == null ) {
        return null;
    }

    Object1 object1 = new Object1();

    object1.setId( object2.getId() );
    object1.setSerialNo( object2.getSerialNo() );

    return object1;
}
...