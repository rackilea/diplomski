char c;  
    for(int i=1;i<l;i++)
    {
         c=str[i];
         int j=i;
         while(j>0 && c<str[j-1])
         {                 
             str[j]=str[j-1];
             str[j-1]=c;
             --j;
         }
    }