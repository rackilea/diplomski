ByteBuffer bb = ByteBuffer.wrap(" someString 8\r\nsome other string -88\n".getBytes());
while(bb.remaining()>0) {
    int start = bb.position(),end, ptr;
    for(end = start;end < bb.limit();end++) {
        byte b = bb.get(end);
        if (b == '\r' || b == '\n')
            break;
    }
    // read the number backwards
    long value = 0;
    long tens = 1;
    for(ptr = end-1;ptr>= start;ptr--) {
        byte b = bb.get(ptr);
        if (b >= '0' && b <= '9') {
            value += tens * (b - '0');
            tens *= 10;
        } else if (b == '-') {
            value = -value;
            ptr--;
            break;
        } else {
            break;
        }
    }
    // assume separator is a space....
    byte[] bytes = new byte[ptr-start];
    bb.get(bytes);
    String text = new String(bytes, "UTF-8");
    System.out.println("text: '"+text+"', number: "+value);

    // find the end of the line.
    if (bb.get(end) == '\r') end++;
    bb.position(end+1);
}