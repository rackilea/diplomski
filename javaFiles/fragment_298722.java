String s = "\"Thanks,\", \"in advance,\", \"for(\"the\", \"help\")\"";
String regex = "\"(\\([^)]*\\)|[^\"])*\"";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(s);
while(m.find()) {
    System.out.println(s.substring(m.start(),m.end()));
}