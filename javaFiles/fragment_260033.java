public class test
{
    public static void main(String[] args)
    {
        String[] newString = "242342.4242+424-32.545".split("[-+*/]");
        for (String s : newString)
        {
            System.out.println(s);
        }
    }
}