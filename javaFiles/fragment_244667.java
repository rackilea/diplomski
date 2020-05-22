String str = "a:[AAAA|0.1;BBBBBBB|-1.90824;CC|0.0]";
String[] substrings = str.split("[^A-Z]+");
for (String s : substrings)
{
    if (!s.isEmpty())
    {
        System.out.println(s);
    }
}