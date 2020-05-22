private static int toInt(Number number) {
    if( number == null ) {
        return 0;
    }
    return ((int) (number.doubleValue() * 100.0)); // Example only
}