String template = "key1=value1&key2=value2&key3=value3";
String pattern = "&?([^&]+)="; 

Pattern p = Pattern.compile(pattern);
Matcher m = p.matcher(template);

while (m.find()) 
{
    System.out.println(m.group(1)); //prints capture group number 1
}