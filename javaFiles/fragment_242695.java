public static void main( String[] args ) throws IOException
{
    File f = new File( args[ 0 ] );
    System.err.printf( "args[0]: %s\n", args[ 0 ] );
    System.err.printf( "Path: %s\n", f.getCanonicalPath() );
}