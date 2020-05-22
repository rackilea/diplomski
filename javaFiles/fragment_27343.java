System.out.println("file:" + input.getFilePointer() + "/" + input.length());
if (input.getFilePointer() >= input.length()) {
    return -1;
}
System.out.println("Attempt to read byte: "+ input.getFilePointer());
int b = (int) input.readByte() & 0xff;
System.out.println(b);
return b;