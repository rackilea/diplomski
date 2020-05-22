public class Matrix
{
    private int amountOfRows;
    private int amountOfColumns;
    private int[][] matrixArray;

    public Matrix(int amountOfRows, int amountOfColumns)
    {
        this.amountOfRows = amountOfRows;
        this.amountOfColumns = amountOfColumns;
        matrixArray = new int[amountOfRows][amountOfColumns];

        fillMatrixArray();
    }

    private void fillMatrixArray()
    {
        int count = 0;
        for(int r = 0; r < amountOfRows; r++)
        {
            for(int c = 0; c < amountOfColumns; c++)
            {
                if(count < 9)
                {
                    count++;
                    matrixArray[r][c] = count;
                }
                else
                {
                    // If we reached 9, we reset back to 1
                    count = 1;
                    matrixArray[r][c] = count;
                }
            }
        }
    }

    public int[][] getMatrixArray()
    {
        return matrixArray;
    }

    public int getAmountOfRows()
    {
        return this.amountOfRows;
    }

    public int getAmountOfColumns()
    {
        return this.amountOfColumns;
    }

    public void show()
    {
        for(int r = 0; r < amountOfRows; r++)
        {
            for(int c = 0; c < amountOfColumns; c++)
            {
                System.out.print(matrixArray[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // TODO: rotateColumn(int columnNr)

    // TODO: rotateRow(int rowNr)
}