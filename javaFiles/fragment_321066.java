// do this once to setup
CharsetEncoder enc = Charset.forName("ISO-8859-1").newEncoder();

// for each string
int len = str.length();
byte b[] = new byte[len + 1];
ByteBuffer bbuf = ByteBuffer.wrap(b);
enc.encode(CharBuffer.wrap(str), bbuf, true);
// you might want to ensure that bbuf.position() == len
b[len] = 0;