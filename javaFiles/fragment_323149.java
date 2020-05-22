private static final int BUFFER_SIZE = 1024; // Or other reasonable value

// ...

byte[] buffer = new byte[BUFFER_SIZE];
int bytesRead = 0;

// assuming you got the InputStream as "input"
while ( (bytesRead = input.read(buffer)) > 0 ){ // -1 indicates EOF
    // read bytes are now in buffer[0..bytesRead-1]
    // analyse bytes to maybe add up multiple reads to a complete message.
}