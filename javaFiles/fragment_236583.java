public static void main(String[] args)
    throws IOException
{
    String s = "TestSuite1.\n" + 
               "    TestCase1\n" + 
               "    TestCase2\n" + 
               "TestSuite2.\n" + 
               "    TestCase1\n" + 
               "    TestCase2\n" + 
               "    TestCase3";

    Matcher matcher = Pattern.compile("\\w+\\.$(\\s+\\w+$)+", Pattern.MULTILINE).matcher(s);

    while (matcher.find())
    {
        System.out.println(matcher.group());
        System.out.println("-----------");
    }
}

Output:

TestSuite1.
    TestCase1
    TestCase2
-----------
TestSuite2.
    TestCase1
    TestCase2
    TestCase3
-----------