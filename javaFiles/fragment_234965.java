protected boolean isUrlValid( String urlToCheck )
{
    boolean isValid = true;
    try
    {
        new URL( urlToCheck ); // Notice this
    }
    catch ( MalformedURLException exception )
    {
        isValid = false;
    }

    return isValid;
}