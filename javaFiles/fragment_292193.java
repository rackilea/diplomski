StringBuffer b= new StringBuffer();
while (m.find()) {
    String spaces= StringUtils.repeat(" ", m.end()-m.start());
    m.appendReplacement(b, spaces);
}
m.appendTail(b);
stringWithXMLContent= b.toString();