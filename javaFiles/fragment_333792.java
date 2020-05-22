public boolean sameStarChar(String str)
 {
     int len = str.length();
     int no=0,yes=0; 
     for(int x = 0; x < len-1; x++)
       {
         if (str.charAt(x) == '*')
         {
            if((str.charAt(x-1)>='a' && str.charAt(x-1)<='z') && (str.charAt(x+1)>='a' && str.charAt(x+1)<='z'))
            {
              yes++;
            }  
            else{
              no++;
            }
         }
       }
    if(no>0)
        return false;
    else 
        return true;