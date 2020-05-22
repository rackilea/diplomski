int numberOfBytesRead;
while ( true ) {
   numberOfBytesRead = in.read(buffer); //read bytes into buffer
if ( numberOfBytesRead == -1 ) break; //end of stream
   out.write(buffer, 0, numberOfBytesRead); //write the same # of bytes we read
}