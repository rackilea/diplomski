public static boolean isDouble( String input ) {
    try {
        Double.parseDouble(input );
        return true;
    }
    catch( Exception e ) {
        return false;
    }
}