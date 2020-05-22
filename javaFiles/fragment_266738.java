public static int countToken(Scanner s, String t)
{
    int count=0;
    String token="";
    while (s.hasNext())
    {
        token = s.next();

        if(token.equals(t))
        {
        count++;
        }
        else
        {
        }
    }
    return count;
}