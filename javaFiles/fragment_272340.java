Pattern p = Pattern.compile("(?<key>\\w+)\\s*:\\s*(?<value>\\w+)");
Matcher m = p.matcher(yourData);
while(m.find()){
    System.out.println("key = " + m.group("key"));
    System.out.println("value = " + m.group("value"));
    System.out.println("--------");
}