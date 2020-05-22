public class NewClass
{
    public static void main(String... args)
    {
        int[][] input = {{5,1,2,0},{2,0,1,4},{1,2,5,5},{3,0,1,3},{4,3,0,4},{3,2,5,4}};
        mapOrientation(input);
    }

    public static int [][] mapOrientation(int input[][])
    {
        int[][] mappings ={{0,2,3,4,1,5},{1,2,0,4,5,3},{5,2,1,4,3,0},{3,2,5,4,0,1},
                           {3,5,4,0,2,1},{2,5,3,0,1,4},{1,5,2,0,4,3},{4,5,1,0,3,2},
                           {4,1,0,3,5,2},{5,1,4,3,2,0},{2,1,5,3,0,4},{0,1,2,3,4,5},
                           {0,4,1,2,3,5},{3,4,0,2,5,1},{5,4,3,2,1,0},{1,4,5,2,0,3},
                           {1,0,4,5,2,3},{2,0,1,5,3,4},{3,0,2,5,4,1},{4,0,3,5,1,2},
                           {4,1,0,3,5,2},{5,1,4,3,2,0},{2,1,5,3,0,4}};

        System.out.println("Before");
        System.out.println(Arrays.deepToString(input));

        int[] mapping = mappings[0];
        for(int i = 0; i < input.length; i++)
        {
            for(int j = 0; j < input[i].length; j++)
            {
                input[i][j] = mapping[input[i][j]];
            }
        }

        System.out.println("After");
        System.out.println(Arrays.deepToString(input));

        //cubeToString = Arrays.deepToString(input);

        return input;
    }
}