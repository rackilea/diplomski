Matcher m = Pattern.compile("&?([^&]+)=").matcher("key1=value1&key2=value2&key3=value3");

while (m.find()) 
{
    System.out.println(m.group(1)); //prints capture group number 1
}