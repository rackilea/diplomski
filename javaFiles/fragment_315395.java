String s = "foo/* i am helpful\n" + 
        "i am great\n" + 
        "*/"
        + "bar";
Pattern p = Pattern.compile("(?s)/\\*.*?\\*/");
Matcher m = p.matcher(s);
while(m.find())
{
    System.out.println(m.group());
}