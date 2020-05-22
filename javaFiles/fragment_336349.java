void display() 
{
    int i=0,k;
    for(i=1;i<=5;i++)
    {
         for(k=1;k<=5;k++)
         {
             if (k < i ) {
                 System.out.print(i);
             } else {
                 System.out.print(k);
             }
         }
         System.out.println();
    }
}