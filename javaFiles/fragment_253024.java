int bufferSize = 1024;
byte[] buffer = new byte[bufferSize];
int remaining = length;
int read = 0;
while (remaining > 0 
       && (read = in.read(buffer, 0, Math.min(remaining, bufferSize))) >= 0) {
   out.write(buffer, 0, read);
   remaining -= read;
}