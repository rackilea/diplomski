public class TestSplit

{

    public static void main(String args[])

    {

        String str = new String("I Love Java <=> I Love Python <=> I Love Stackoverflow");
        for (String retval: str.split("<=> "))
        {
                System.out.println(retval);
        }


    }
}