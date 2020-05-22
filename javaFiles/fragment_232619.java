String n="1 21 16 17 9 8 22 20 10";
Pattern p=Pattern.compile("\\b(1[0-9]|[0-9])\\b");
Matcher m=p.matcher(n);
while(m.find())
    System.out.println(n.substring(m.start(),m.end()));
}