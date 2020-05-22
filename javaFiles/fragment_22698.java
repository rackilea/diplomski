Scanner stdin = new Scanner(System.in);
System.out.println("Enter number of rows and columns: ");

int row = stdin.nextInt();
int column = stdin.nextInt();

int m = 1;
int n = 1;

while(m <= column)
{
    while(n <= row)
    {
        System.out.println("*\t");
        n++;
    }
    System.out.print("*");
    m++;
}