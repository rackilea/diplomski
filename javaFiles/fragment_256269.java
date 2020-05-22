public static void main(String[] args)
{

    int temp=0;
    boolean error=false;
    do{
        error=false;
        try
        {
            Scanner scan = new Scanner(System.in);
            System.out.print("enter number ");
            temp = scan.nextInt();
            if(temp==0)
                break;



            if(temp >= 5 && temp <= 40)
            { 
                int x = (temp-1)*2 +1; 
                int y = x/2;  
                int z = 1;  
                for(int i=0; i<temp-1; i++) 
                {
                    for(int j=0; j<=y; j++) 
                    {
                        System.out.print(" ");
                    }
                    for(int k = 0; k<z; k++) 
                    {
                        System.out.print("|");
                    }
                    System.out.println(); 
                    y--;
                    z+=2; 
                }

                for(int c = 0; c < 1 + temp/10; c++) 
                {
                    for (int i = 0; i <= x / 2; i++)
                    {
                        System.out.print(" ");
                    }
                    System.out.println("|");
                }
            }
            else
            {
                System.out.println("enter a number between 5 and 40");
            }
        }catch(Exception e)
        {
            System.out.println("Enter a valid number..try again");
            error=true;
        }
    }while(temp != 0 || error);
}