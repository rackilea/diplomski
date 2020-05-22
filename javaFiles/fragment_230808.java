if((len%2)!=0)
   { 
       A=b.substring(len-1,len);
       len=len-1;
       b=b.substring(len-1); // this returns a String with the last 2 characters of
                             // the original
       flag=1;
   }