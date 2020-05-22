public static int min( int[] array ) throws ArrayIndexOutOfBoundsException {
    if ( array == null || array.length == 0 ) {
        throw new ArrayIndexOutOfBoundsException();
    }
    Arrays.sort( array );
    int minValue = array[0];
    return minValue;
}