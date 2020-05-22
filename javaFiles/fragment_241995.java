public class ServletUtilities
{
  public static String filter(String input)
  {
     if(!hasSpecialChars(input))
     {
       StringBuffer filtered = new StringBuffer(input.length());
       char c;
       for(int i=0; i < input.length(); i++)
       {
         c = input.charAt(i);
         switch(c)
         {
           case '<' : filtered.append("&lt;");break;
           case '>' : filtered.append("&gt;");break;
           case '"' : filtered.append("&quot;");break;
           case '&' : filtered.append("&amp;");break;
           //This next one is optional for the new line
           case '\n' : filtered.append("<br>");break;
           default: filtered.append(c);
         }
       }
       return(filtered.toString()); 
     }
  }

  private static Boolean hasSpecialChars(String input)
  {
    boolean flag = false;

    if((input != null) && (input.length() > 0))
    {
       char c;
       for(int i=0; i < input.length(); i++)
       {
         c = input.charAt(i);
         switch(c)
         {
           case '<' : flag = true;break;
           case '>' : flag = true;break;
           case '"' : flag = true;break;
           case '&' : flag = true;break;
           //This next one is optional for the new line
           case '\n' : flag = true;break;
         }
       }
    }
    return flag;
  }
}