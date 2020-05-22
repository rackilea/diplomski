Pattern p = Pattern.compile("(\\d)\\-(\\d)\\-(\\d)");
Matcher m = p.matcher(select.toString());
if(m.find())
{
    System.out.println( "Position 1 is : " + m.group(1) );
    System.out.println( "Position 2 is : " + m.group(2) );
    System.out.println( "Position 3 is : " + m.group(3) );
}