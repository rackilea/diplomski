public static void main(String[] args) throws InterruptedException
{
    try
    {
        Integer.parseInt(args[0]);
    }
    catch(NumberFormatException e)
    {
        System.out.println("It is not a number.");
    }
}