byte[] buf = ...;
int res = somefunction(buf); 
byte[] buf2 = new byte[buf.length + 1];
System.arraycopy(buf, 0, buf2, 0, buf.length);
buf2[buf.length] = (byte)res;
buf = buf2;