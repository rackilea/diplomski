public class MatrixNeighborCount
{
    public static void main(String[] args)
    {
        int array[][] = new int[][]{
            { 0, 0, 1, 0 },
            { 0, 1, 1, 0 },
            { 0, 0, 0, 1 },
        };
        int result[][] = count(array);
        print(result);
    }

    private static void print(int array[][])
    {
        for (int r=0; r<array.length; r++)
        {
            for (int c=0; c<array[r].length; c++)
            {
                System.out.printf("%3d", array[r][c]);
            }
            System.out.println("");
        }
    }

    private static int[][] copy(int array[][])
    {
        int result[][] = new int[array.length][];
        for (int i=0; i<array.length; i++)
        {
            result[i] = array[i].clone();
        }
        return result;
    }

    private static int[][] count(int inputArray[][])
    {
        int result[][] = new int[inputArray.length][];
        for (int i=0; i<inputArray.length; i++)
        {
            result[i] = new int[inputArray[i].length];
        }

        int array[][] = copy(inputArray);
        for (int r=0; r<array.length; r++)
        {
            for (int c=0; c<array[r].length; c++)
            {
                if (array[r][c] == 1)
                {
                    int count = count(array, r, c);
                    distribute(inputArray, result, r, c, count);
                }
            }
        }
        return result;
    }

    private static int count(int array[][], int r, int c)
    {
        if (!valid(array, r, c)) return 0;
        if (array[r][c] == 0) return 0;

        array[r][c] = 0;
        return 1 + 
            count(array, r-1, c) +
            count(array, r+1, c) +
            count(array, r, c-1) +
            count(array, r, c+1);
    }

    private static void distribute(
        int inputArray[][], int result[][], int r, int c, int value)
    {
        if (!valid(inputArray, r, c)) return;
        if (inputArray[r][c] == 0) return;
        if (result[r][c] != 0) return;
        result[r][c] = value;
        distribute(inputArray, result, r-1, c, value);
        distribute(inputArray, result, r+1, c, value);
        distribute(inputArray, result, r, c-1, value);
        distribute(inputArray, result, r, c+1, value);
    }

    private static boolean valid(int array[][], int r, int c)
    {
        if (r < 0) return false;
        if (r >= array.length) return false;
        if (c < 0) return false;
        if (c >= array[r].length) return false;
        return true;
    }
}