public static void main(String[] args) {
    int l= 5;int k=0;
     for(int x=1;x<5;x++)
        {
         for(int i=l*2-1;i>0;i--)
         {  
            if(x == 1 && i ==1)
                break;
            System.out.print(" "); 
         }
         System.out.print(x); 
         System.out.print(" "); 
         for(int i=1;i<x*2-2;i++)
         {
             System.out.print(x); 
             System.out.print(" "); 
         }
         System.out.println();
         l--;
        }

        }