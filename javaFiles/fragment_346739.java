System.out.println(Charset.defaultCharset().name());
ByteBuffer bybf = ByteBuffer.wrap("Olé".getBytes());
Charset utf16 = Charset.forName("UTF-16");
CharBuffer chbf = utf16.decode(bybf);
System.out.println(chbf);
bybf = ByteBuffer.wrap("Olé".getBytes(utf16));
chbf = utf16.decode(bybf);
System.out.println(chbf);