Scanner pal = new Scanner (System.in);
System.out.println("Enter the number of rows you want");
int n = pal.nextInt();
int rows = 0;
while (rows < n)
{
    int column = 0;
    while (column < n - rows)
    {
        System.out.print(" ");
        column++;
    }
    int currentStars = 0;
    while (currentStars <= rows)
    {
        System.out.print(" *"); 
        currentStars++;
    }
    System.out.print("\n");
    rows++;
}