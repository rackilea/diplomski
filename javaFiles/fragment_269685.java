char[] chars = content.toCharArray();  // removed from loop per leonbloy's excellent comment  
CharBuffer cbuf = my_content.asCharBuffer();

for (int i = 0; i < content.length(); i++) {
    cbuf.putChar(chars[i]);
}

CharBuffer debug = my_content.asCharBuffer();
System.out.println(debug);

my_content.position(my_content.position() + 2*chars.length);