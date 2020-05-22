StringBuilder sb = new StringBuilder();
while(bb.hasRemaining()) {
    byte b = bb.get();
    if((b >= 32 && b < 127) || b == 10) {
        sb.append((char) b);
    }
}
String result = sb.toString();