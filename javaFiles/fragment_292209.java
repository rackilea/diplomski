public class TestSplit

{

    public static void main(String args[])
    {
        String str = new String("I Love Java <=> I Love Python");


        for (String retval: str.split("<=> ",2))
        {

                System.out.println(retval);
        }


    }
}