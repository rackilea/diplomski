byte[] message = new byte[0]; 
byte[] buffer  = new byte[4096];
int    len;
while(( len = is.read( buffer )) > -1 ) {
   byte[] tmp = new byte[message.length+len];
   System.arraycopy( message, 0, tmp, 0, message.length );
   System.arraycopy( buffer , 0, tmp, message.length, len );
   message = tmp;
}
messageListener.messageReceived( message );