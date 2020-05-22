public static void add( List<YourClass> list, YourClass o ) {
    for ( int i = 0 ; i < list.size(); i++ ) {
        if ( list.get(i).position() > o.position() ) {
            list.add(i, o);
            return;
        }
    }
    list.add(o);
}