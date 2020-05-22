StringBuffer sb = new StringBuffer()
while (true) {
    String s = bw.readLine();
    if (s == null) break;
    sb.append(s);
    // Uncomment the next line to add separators between lines
    // sb.append('\n');
}
s1 = sb.toString();