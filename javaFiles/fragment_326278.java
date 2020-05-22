String n ="${farsiName} - {symbolName}";

Pattern p = Pattern.compile("\\{(.*?)\\}");
Matcher m = p.matcher(n);

while(m.find()) {
    System.out.println(m.group(1));
}