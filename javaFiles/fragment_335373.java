InputStream is;

// Create a buffer large enough for the response header (and drop exception if it is bigger).
byte[] headEnd = {13, 10, 13, 10}; // \r \n \r \n
byte[] buffer = new byte[10 * 1024];
int length = 0;

// Read bytes to the buffer until you find `\r\n\r\n` in the buffer. 
int bytes = 0;
int pos;
while ((pos = arrayIndexOf(buffer, 0, length, headEnd)) == -1 && (bytes = is.read(buffer, length, buffer.length() - length)) > -1) {
    length += bytes;

    // buffer is full but have not found end siganture
    if (length == buffer.length())
        throw new RuntimeException("Response header too long");
}

// pos contains the starting index of the end signature (\r\n\r\n) so we add 4 bytes
pos += 4;

// When you encounter the end of header, create a strinform the first *n* bytes
String header = new String(buffer, 0, pos);

System.out.println(header);

// Be prepared that the buffer will contain additional data after the header
// ... so we process it
System.out.write(buffer, pos, length - pos);

// process the rest until connection is closed
while (bytes = is.read(buffer, 0, bufer.length())) {
    System.out.write(buffer, 0, bytes);
}