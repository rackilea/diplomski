int r=0,c=0;             //r and c are global variables

  public static void businessclass_update(int myarray1[][]) 
  {   

           if (myarray1[1][4]==1 && myarray1[10][4]==1)
               System.out.println("Ferry Full");

            else if(myarray1[r][c]==0) 
                {
                         myarray1[r][c]=1;
                         c++;
                         if(c==5)                //If row is full move to next row
                         {
                             c=0;
                             r++;
                         }
                 }

            else if(myarray1[1][4]==1)
                System.out.println("Business Class Full");

}