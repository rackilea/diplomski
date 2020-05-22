public final class Type {

    public static final Type FOO = new Type( "foo" );
    public static final Type BAR = new Type( "bar" );

    private String type;

    private Type( String type ) {
      this.type = type;
    }

    public String getType() { return type; }
}