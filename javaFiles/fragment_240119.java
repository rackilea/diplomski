class Pyramid
{
    public static void main(String[] args) 
    {
         int x=11;
         int y=x/2; // spaces
         int z=1; // *`s

         for(int i=0;i<3;i++)
        {
             for(int j=0;j<y;j++)
            {
                 System.out.print(" ");
            }
            for(int k=0;k<z;k++)
            {
                System.out.print("*");
            }

            y=y-1;
            z=z+2;
            System.out.println();  //new line
        }

    }
}