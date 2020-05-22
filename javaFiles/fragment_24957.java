Pattern p = Pattern.compile("10+1");
String s = "100001abc101";
Matcher m = p.matcher(s);
int i = 0;
while(m.find()){
    i++;
}
System.out.println(i);