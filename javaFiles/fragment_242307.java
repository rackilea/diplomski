String str = "(&(objectCategory=group)(|(cn=groupA) (cn=groupB) (cn=groupC) ))";
Pattern regex = Pattern.compile("(?<=\\(cn=)[^()]*(?=\\))");
Matcher matcher = regex.matcher(str);
while(matcher.find()){
System.out.println(matcher.group(0));
}