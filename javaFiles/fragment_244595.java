public static Copyable[] copyOf(Copyable[] objects) {
    Copyable[] copies = new Copyable[objects.length];
    for( int i=0; i < copies.length; ++i ) {
        if( objects[i] == null )
            throw new IllegalArgumentException("Copyable[] contains null reference", new NullPointerException());
        copies[i] = objects[i].copy();
    }
    return copies;
}