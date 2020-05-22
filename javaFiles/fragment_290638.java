CharsetEncoder e=Charset.forName("ISO-8859-1").newEncoder();
// this will pass
if(!e.canEncode("hello iso latin 1"))
  throw new CharacterCodingException();
// this will throw
if(!e.canEncode("\u20ac is a non-latin-1 character"))
  throw new CharacterCodingException();