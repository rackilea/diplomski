public static void main( String[] args) 
{
   // Scanner scan = new Scanner( System.in);
    int x,y;
    int[][] table = new int[11][11];
    table[0][0] = 0;
    table[0][1] = 1;
    table[0][2] = 2;
    table[0][3] = 3;
    table[0][4] = 4;
    table[0][5] = 5;
    table[0][6] = 6;
    table[0][7] = 7;
    table[0][8] = 8;
    table[0][9] = 9;;
    table[0][10] = 10;  
    table[1][0] = 1;
    table[2][0] = 2;
    table[3][0] = 3;
    table[4][0] = 4;
    table[5][0] = 5;
    table[6][0] = 6;
    table[7][0] = 7;
    table[8][0] = 8;    
    table[9][0] = 9;
    table[10][0] = 10;

    int[][] output_table = new int[11][11];

    System.out.println( "Start of multiplication\n");

    for (x = 0; x < 10; x++)
    {
        System.out.println("Table of: "+table[x][0]);
        for (y = 0; y < 10; y++)
        {
            output_table[x][y] = table[0][x] * table[y][0];
            System.out.print(output_table[x][y]+"\t");//This line has the error.
        }

        output_table[x][y] = table[0][x] * table[y][0];
        System.out.println(output_table[x][y]);  
    }

    System.out.println( "\nEnd of multiplication\n" );
}