private static class CustomException extends Exception {
}
public static void main (String[] args) throws java.lang.Exception
{
    try
    {
        System.out.println("Calling nocatch(false)");
        nocatch(false);
    }
    catch (CustomException ce) {
        System.out.println("Caught CustomException for false case");
    }
    try
    {
        System.out.println("Calling nocatch(true)");
        nocatch(true);
    }
    catch (CustomException ce) {
        System.out.println("Caught CustomException for true case");
    }
}

public static void nocatch(boolean foo) throws CustomException
{
    try
    {
        if (foo) {
            System.out.println("Throwing");
            throw new CustomException();
        }
    }
    finally
    {
        System.out.println("In finally");
    }
    System.out.println("Reached outside the try/finally block");
}