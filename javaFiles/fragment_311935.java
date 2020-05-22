final Pattern p = Pattern.compile("\\{\"([a-zA-Z\\d$]+)\":\"([^\"]*)\"\\}");
Matcher m = p.matcher("{\"$oid\":\"5527b117d3d511091e1735e2\"}");
if(m.find())
{
    System.out.println("Key : " + m.group(1));
    System.out.println("Value : " + m.group(2));
}