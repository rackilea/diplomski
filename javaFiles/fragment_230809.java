if((len%2)!=0)
   { 
       A=b.substring(len-1,len);    
       len=len-1;
       b=b.substring(0,len); // this would return the original String minus the last
                             // character
       flag=1;
   }