Scanner ob = new Scanner(System.in);
int row = 0, col = 0;
while(true)
{
    System.out.println("Enter the number of rows:");
    row = ob.nextInt();
    if(row <= 10 && row > 0) break;
    else System.out.println("Invalid input. Try again.");
}
while(true)
{
    System.out.println("Enter the number of columns:");
    col = ob.nextInt();
    if(col <= 10 && col > 0) break;
    else System.out.println("Invalid input. Try again.");
}
LandVille landVille = new LandVille(row, col);