int firstMismatch(String org, String check)
{
    int limit = (org.length()>check.length())?org.length():check.length();
    for(int i=0;i<limit;i++)
    {
        try{
        if(org.charAt(i)!=check.charAt(i))
        {
             return i; //If one of the strings end, that's the position they are different, otherwise there is a mismatch. Either way, just return the index of mismatch
        }
        }
        catch(Exception e)
        {
             if(org.length()!=check.length())
            {

             return(i); //Execution comes here only when length of strings is unequal
         //Exception occurs because first string is smaller than
         // the second or vice versa. Say if you use "fred" and"fredd" as org and check 
         //respectively, "fred" is smaller than "fredd" so accessing org[4] is not allowed.   
         //Hence the exception.
          }

           System.out.println("Problem encountered"); //Some other exception has occured.
          return(-2);
        }  
    }
    return(-1); //if they are equal, just return -1



}