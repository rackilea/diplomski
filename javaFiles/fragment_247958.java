try
{
    throw new CustomException();
}
finally
{
    return; // <=== Makes the compiler happy (but don't do it!)
}