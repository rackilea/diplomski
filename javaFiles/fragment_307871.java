String str = "Free concert at 8 pm over there"
        + "Free concert at 8pm over there"
        + "Free concert at 8:30 pm over there"
        + "Free concert at 8:30pm over there";

Pattern p = Pattern.compile("(?i)[0-9]{1,2}:??[0-9]{0,2}\\s??(?:am|pm)");
Matcher m = p.matcher(str);

while( m.find() )
{
    System.out.println(m.group());
}