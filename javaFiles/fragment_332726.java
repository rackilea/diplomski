// all chars (i.e. UTF-16 values)
StringBuilder sb=new StringBuilder(Character.MAX_VALUE);
for(char c=0; c<Character.MAX_VALUE; c++) sb.append(c);
String s=sb.toString();
// if it should behave like a compile-time constant:
s=s.intern();