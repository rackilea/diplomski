String s = "every day every night every minute every second";
StringBuilder sb = new StringBuilder();
int last = -1;
while (true) {
    int i = s.indexOf(' ', last+1);
    if (i < 0) break;
    i = s.indexOf(' ', i+1);
    if (i < 0) break;
    sb.append(s.substring(last+1,i)).append(", ");
    last = i;
}
sb.append(s.substring(last+1));
String result = sb.toString();
System.out.println(result);