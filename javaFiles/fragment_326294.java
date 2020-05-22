StringBuffer sb = new StringBuffer();
while(m.find()){
    m.appendReplacement(sb, /*replacement for each match*/);
}
m.appendTail(sb);
String result = sb.toString();