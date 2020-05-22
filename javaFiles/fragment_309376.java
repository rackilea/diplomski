String in = "hello \"there\", \"friend!\"";
Pattern p = Pattern.compile("\\\"([^\"]*)\\\"");
Matcher m = p.matcher(in);
while(m.find()){
    System.out.println(m.group(1));
    in = m.replaceFirst("");
    m = p.matcher(in);
}
System.out.println(in);