// assuming you have r and s as !!positive!! BigIntegers
// (if you have unsigned byte[] as shown in your Q, 
// use BigInteger r = new BigInteger (1, bytes) etc.

byte[] rb = r.toByteArray(), sb = s.toByteArray(); // sign-padded if necessary
// these lines are more verbose than necessary to show the structure
// compiler will fold or you can do so yourself 
int off = (2+2)+rb.length, tot = off+(2-2)+sb.length;
byte[] der = new byte[tot+2];
der[0] = 0x30; der[1] = tot;
der[2+0] = 0x02; der[2+1] = rb.length; System.arraycopy(rb,0, der,2+2, rb.length);
der[off+0] = 0x02; der[off+1] = sb.length; System.arraycopy(sb,0, der,off+2, sb.length);