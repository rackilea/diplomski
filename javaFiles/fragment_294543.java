class Foo implements Externalizable {
    /**
     * DO NOT USE THIS CONSTRUCTOR! This only exists for Externalizable
     */
    public Foo( ) {
        id = null;
        children = null;
    }

    @Override public void writeExternal( final ObjectOutput o ) throws IOException {
        o.writeInt( id.intValue( ) );
        o.writeObject( children );
    }

    @SuppressWarnings( "unchecked" )
    @Override public void readExternal( final ObjectInput o ) throws IOException, ClassNotFoundException {
        id = Integer.valueOf( o.readInt( ) );
        children = (Set<Foo>) o.readObject( );
    }

    // rest of code as before
}