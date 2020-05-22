private static final int BUFFER_SIZE = 3 * 1024;

try ( BufferedInputStream in = new BufferedInputStream(input, BUFFER_SIZE); ) {
    Base64.Encoder encoder = Base64.getEncoder();
    StringBuilder result = new StringBuilder();
    byte[] chunk = new byte[BUFFER_SIZE];
    int len = 0;
    while ( (len = in.read(chunk)) == BUFFER_SIZE ) {
         result.append( encoder.encodeToString(chunk) );
    }
    if ( len > 0 ) {
         chunk = Arrays.copyOf(chunk,len);
         result.append( encoder.encodeToString(chunk) );
    }
}