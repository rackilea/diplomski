String str = "(( Relationship=11 ) AND ( Relationship=12 ) AND ( Relationship=1 ))";
String regex = "=(\\d+)";
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(str);

while (matcher.find()) {                                                
    System.out.println(matcher.group(1));
}