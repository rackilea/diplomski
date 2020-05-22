CharBuffer charBuf = CharBuffer.allocate(1000);
for (int i = 0; i < 10; i++) 
{
    String text = "testing" + i + "\n";
    charBuf.put(text);
}
charBuf.rewind();
System.out.println(charBuf);