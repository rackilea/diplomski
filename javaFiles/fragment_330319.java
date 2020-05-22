public static void main(String[] args) 
{
    for(int height=0; height<5; height+=2)
    {
        System.out.print("-");
        for(int width=5; width-height>0; width--)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}