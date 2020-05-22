public class Blah
{
    public String hello;

    public Blah()
    {
        try
        {
            fail();
            hello = "hi";
        } 
        catch (IOException e)
        {
            System.err.println("Exception caught!");
        }
    }

    private void fail() throws IOException
    {
        throw new IOException();
    }

    public static void main(String[] args)
    {
        Blah blah = new Blah();
        System.out.println(blah.hello);
    }
}