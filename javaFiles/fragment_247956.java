public static void nocatch() throws CustomException
{
    try
    {
        throw new CustomException();
    }
    finally
    {

    }
}