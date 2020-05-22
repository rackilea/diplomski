// all unicode characters (aka code points)
StringBuilder sb=new StringBuilder(2162686);
for(int c=0; c<Character.MAX_CODE_POINT; c++) sb.appendCodePoint(c);
String s=sb.toString();
// if it should behave like a compile-time constant:
s=s.intern();