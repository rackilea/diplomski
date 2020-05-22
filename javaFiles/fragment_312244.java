private int getIntegerValue(String s) {
    if ( "".equals(s) ) {
        return 0;
    }
    return Integer.parseInt(s);
}