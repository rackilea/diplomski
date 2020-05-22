// First read the file's length (4 bytes)
int b1 = is.read();
int b2 = is.read();
int b3 = is.read();
int b4 = is.read();
if (b1 < 0 || b2 < 0 || b3 < 0 || b4 < 0)
    throw new EOFException(); // Less than 4 bytes received, end of stream
int length = (b1 << 24) + (b2 << 16) + (b3 << 8) + b4;

// And now read the content of the file which must be exactly length bytes