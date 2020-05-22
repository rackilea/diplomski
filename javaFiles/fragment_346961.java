int rows = 0; // the Java default value for integers is 0. Equivalent: int rows;
int cols = 0; // equivalent: int cols;

Scanner scan = new Scanner (System.in);

System.out.print("Enter in a row  :");
rows = scan.nextInt();
System.out.print("Enter in a col :");
cols =scan.nextInt();

int[][] board = new int[rows][cols]; // now has values other than 0

for (int i = 0; i < rows; i++)
{
   for (int j = 0; j < cols; j++) 
   {
      board[i][j] = 0;
      System.out.print ("\t" + board[i][j]);                         
   } 
   System.out.print ("\n"); 
}