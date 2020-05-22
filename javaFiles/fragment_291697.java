public static boolean duplicates (int [] x, int numElementsInX ) {
    Set<Integer> set = new HashSet<Integer>();
    for ( int i = 0; i < numElementsInX; ++i ) {
        if ( set.contains( x[i])) {
            return true;
        }
        else {
            set.add(x[i]);
        }
    }
    return false;
}