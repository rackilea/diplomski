CharsetEncoder e=Charset.forName("ISO-8859-1").newEncoder();
// tell that we want an exception
e.onUnmappableCharacter(CodingErrorAction.REPORT);
// this will pass
e.encode(CharBuffer.wrap("hello iso latin 1"));
// this will throw
e.encode(CharBuffer.wrap("\u20ac is a non-latin-1 character"));