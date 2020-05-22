int bytesRead;
while ( ( bytesRead = in.read(buffer)) > 0) {
   byte outBuffer[] = new byte[bytesRead];
   ... then use arraycopy to move bytesRead bytes
   out.write(outBuffer);
}