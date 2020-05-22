int y;
if ( enable_beacon_timestamp > (long)Integer.MAX_VALUE ) {
    // long is too big to convert, throw an exception or something useful
}
else {
    y = (int)enable_beacon_timestamp;
}