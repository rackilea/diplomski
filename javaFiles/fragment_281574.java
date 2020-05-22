String received = "28,gZrate:-1.48},{gXrate:9.10,gYrate:-0.69,gZrate:-1.50},";
       received += "{gXrate:9.22,gYrate:0.54,gZrate:-1.67},";
       received += "{gXrate:9.20,gYrate:-2.40,gZrate:-1.65},{gXrate:9.02";
String pattern = "\\{(.*?)\\},?";
StringBuilder sb = new StringBuilder("[");
boolean first = true;

Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(received);
while (m.find()) {
    if (!first) {
        sb.append(",");
    }
    first = false;
    sb.append("\"" + m.group(1) + "\"");
}
sb.append("]");
System.out.println(sb);