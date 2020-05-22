String str = "1 + 1555.0056q + 34.0g - 451-0.7855";
Matcher m = Pattern.compile("[+-]?\\s*\\d+(?:\\.\\d+)?(?=[-+\\s]|$)").matcher(str);
while(m.find())
{
    System.out.println(m.group());
}