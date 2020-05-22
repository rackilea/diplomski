import java.util.*;

public class TwoDArray
{
    public static void main(String... args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);        
        int[][] array = {    
                             {0, 1, 2, 3, 4, 5, 6, 7, 8},       
                             {9, 10, 11, 12, 13, 14, 15, 16, 17},                                                                                       
                             {18, 19, 20, 21, 22, 23, 24, 25, 26},
                             {27, 28, 29, 30, 31, 32, 33, 34, 35},
                             {36, 37, 38, 39, 40, 41, 42, 43, 44},
                             {45, 46, 47, 48, 49, 50, 51, 52, 53},
                             {54, 55, 56, 57, 58, 59, 60, 61, 62},
                             {63, 64, 65, 66, 67, 68, 69, 70, 71},
                             {72, 73, 74, 75, 76, 77, 78, 79, 80}
                            };  

        displayMatrix(array);
        displayEachBlock(array);        
    }

    private static void displayMatrix(int[][] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (i == 3 || i == 6)
                System.out.println("------------------------------------");
            for (int j = 0; j < array[i].length; j++)
            {
                System.out.format("%-3s", array[i][j]);
                if (j == 2 || j == 5 || j == 8)
                    System.out.print(" | ");
            }           
            System.out.println();   
        }      
        System.out.println("------------------------------------");
    }

    private static void displayEachBlock(int[][] array)
    {
        for (int i = 0; i < array.length; i += 3)
        {           
            for (int j = 0; j < array[i].length; j += 3)
            {
                /*
                 * Here we are finding which block we are standing at.
                 */
                int block = (((i / 3) * 3) + (j / 3));
                System.out.println("Block : " + block);
                int[][] newArray = new int[3][3];
                int newRow = 0;
                for (int k = i; k < (i + 3); k++)
                {
                    int newColumn = 0;
                    for (int l = j; l < (j + 3); l++)
                    {
                        // This is where you are getting your array inside the given block.
                        newArray[newRow][newColumn] = array[k][l];
                        System.out.format("[%-1s][%-1s] : %-3s ", newRow, newColumn, newArray[newRow][newColumn++]);
                    }
                    newRow++;
                    System.out.println();
                }
                // Here you can send your newArray for VALIDATION, thingy.
                // So that we can move on to the next Block for further processing.
            }
        }
    }
}