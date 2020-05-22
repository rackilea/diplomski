int read = 0;
while(read < size) {
    int r = is.read(fileData, read, size-read);
    if(r < 0) {
       // end of file, should not occur if noone interrupts your stream or such
       throw new EOFException("input ended prematurely");
    }
    read += r;
}