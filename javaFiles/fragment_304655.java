Scanner scanner=new Scanner(System.in);
String m;
System.out.println("Enter the date (yyyy-mm-dd) :");
m=scanner.next()+" ";

CharBuffer  c = CharBuffer.wrap(m);
System.out.println("Sending date ...: " + c);
ByteBuffer b = Charset.forName("ISO-8859-1").encode(c);
 b.compact();
System.out.println("Bytebuffer has the capacity of "+ 
b.capacity() + "pointer position on bytebuffer is on: "+ b.position() + " and the limit is:" + b.limit());
b.flip();