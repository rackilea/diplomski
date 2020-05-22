InputStream in = socket.getInputStream();

for(int b; ((b = in.read()) > 0;) {
   // do something with b.
}
// stops at end of file or b == 0.