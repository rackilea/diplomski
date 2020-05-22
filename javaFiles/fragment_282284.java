String str = "\u8ba9\u4ed6\u51fa\u6d77\u4e86";
StringReader sr = new StringReader(str);
UnicodeUnescapeReader uur = new UnicodeUnescapeReader(sr);

StringBuffer buf = new StringBuffer(); 
for(int c = uur.read(); c != -1; c = uur.read())
{ 
  buf.append((char)c); 
} 
System.out.println(buf.toString());