public static Integer parseInt(String str)
    {
       Integer retVal=-1;
       try
         {
           retVal=Integer.parseInt(str);
         }catch(Exception ex) { return null;}
       return retVal;
     }  
   public static Double parseDouble(String str)
    {
       double retVal=-1;
       try
         {
           retVal=Double.parseDouble(str);
         }catch(Exception ex) { return null;}
       return retVal;
     }  
   public static Character parseChar(String str)
    {
       Character retVal=null;

       if(str.length()==1)
          retVal=str.charAt(0);
       return retVal;
     }