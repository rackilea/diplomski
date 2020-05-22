public static void main(String[] args)
{
    String myString = "foo";
    int a = 0;
    for (int i = 0; i < 100000000; ++i)
    {
        //if (myString != null)
        //if (myString.length() > 0)
        if (!myString.equals(""))
        {
            a++;
        }
    }
    System.out.println(a);
}