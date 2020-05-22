char buffer = new char[1024];
// This will read UP TO 1024 characters from buffer into the
// character array, starting at position 0.
// This may read less then 1024 characters if the underlying
// stream returns -1 indicating and end of stream from
// the read method
int charsIn = reader.read(buffer, 0, 1024);

StringBuilder data = new StringBuilder(charsIn);
data.append(buffer, 0, charsIn);