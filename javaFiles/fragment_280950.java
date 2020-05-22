public static void main(String[] args)
{
    int[][] table = {......}; //where ... is your array data
    int[] sumOfRows = sumTableRows(table);
    for ( int x = 0; x < table.length; x++ )
    {
        for ( int y = 0; y < table[x].length; y++ )
            System.out.print( table[x][y] + "\t" );
        System.out.println( "total: " + sumTableRows[x] );
    }
}

public static int[] sumTableRows(int[][] table)
{
    int rows = table.length;
    int cols = table[0].length;

    int[] sum = new int[rows];
    for(int x=0; x<rows; x++)
        for(int y=0; y<cols; y++)
            sum[x] += table[x][y];
    return sum;     
}