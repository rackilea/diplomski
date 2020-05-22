Cipher cipher = ...
InputStream in = ...
OutputStream out = ...

byte[] inputBuffer = new byte[ BUFFER_SIZE ];
int r = in.read(inputBuffer);
while ( r >= 0 ) {
    byte[] outputUpdate = cipher.update( inputBuffer, 0, r );
    out.write( outputUpdate );
    r = in.read(inputBuffer);
}
byte[] outputFinalUpdate = cipher.doFinal();
out.write( outputFinalUpdate );