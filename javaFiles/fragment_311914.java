String regex = "[1]"; 
String data = "10100010"; 
Matcher m = Pattern.compile(regex).matcher(data);
while(m.find())
{
System.out.println(m.group() + "  => " + (m.start()+1) );
}