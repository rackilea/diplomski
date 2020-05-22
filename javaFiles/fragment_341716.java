int count = 0;
for(int x=0;x<=10;x++)
{
     if(x==1)
     {
         .........//do something;
     }
     else if(x==2)
     {
         count++;
         .........//do something;
         if (count==1)
         {
              x=0;
         }
     }
     //...........
}