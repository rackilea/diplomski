String input = "1\n" + 
        "5.2\n" + 
        "1(2)\n" + 
        "3(*)\n" + 
        "2(3).2\n" + 
        "1(*).5";
Matcher m = Pattern.compile("(?m)^(\\d+)(?:\\((\\d+|\\*)\\))?(?:\\.(\\d+))?$").matcher(input);
while(m.find())
{
    if (m.group(1) != null)
    System.out.println(m.group(1));
    if (m.group(2) != null)
    System.out.println(m.group(2));
    if (m.group(3) != null)
    System.out.println(m.group(3));
}