InputStream is = ...;
int len = ...;
OutputStream out = ...;

int read = 0;
byte[] buf = new byte[8000];
while(read < len) {
    int r = is.read(buf);
    if(r < 0) {
       // end of file, should not occur if noone interrupts your stream or such
       throw new EOFException("input ended prematurely");
    }
    out.write(buf, 0, r);
    read += r;
}