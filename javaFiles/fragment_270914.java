for ( String key : m.values() ) {
    // you put your key in
    m2.put(key, 1);
    // check if it contains the key.... 
    // Of course it does because you just put it in there
    if ( m2.containsKey(key) ) {
        // increment it again
        m2.put(key, m2.get(key) + 1);
    }
}
// after this loop is complete every value in the m2 map is >= 2