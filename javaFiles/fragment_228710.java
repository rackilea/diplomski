InputStream in; // initialized however you're doing
int bytesRead = 0;
byte bytes[60]; // We'll read in up to 60 bytes at a time
while ((bytesRead = in.read(bytes)) > 0) {
    // bytesRead is = to the number of bytes actually read
    // bytes array holds the next 'bytesRead' number of bytes
}