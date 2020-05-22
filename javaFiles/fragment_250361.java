public class LayeredMatrix
{
    public static void main(String[] args)
    {
        test(1,1);
        test(2,2);
        test(3,3);
        test(2,3);
    }

    private static void test(int layers, int colors)
    {
        System.out.println(layers+" layers, "+colors+" colors");
        print(generate(layers, colors));
    }

    private static int[][] generate(int layers, int colors)
    {
        int size = layers * colors * 2;
        int matrix[][] = new int[size][size];
        int layerSize = 2;
        for (int color=0; color<colors; color++)
        {
            int colorOffset = (colors - color - 1) * layers;
            int counter = 1;
            for (int layer = 0; layer < layers; layer++)
            {
                int layerOffset = layers - layer - 1;
                int r0 = colorOffset + layerOffset;
                int c0 = colorOffset + layerOffset;
                int r1 = r0 + layerSize;
                int c1 = c0 + layerSize;
                for (int r=r0; r<r1; r++)
                {
                    for (int c=c0; c<c1; c++)
                    {
                        if (matrix[r][c] == 0)
                        {
                            matrix[r][c] = counter;
                            counter++;
                        }
                    }
                }
                layerSize += 2;
            }
        }
        return matrix;
    }

    private static void print(int matrix[][])
    {
        for (int r=0; r<matrix.length; r++)
        {
            for (int c=0; c<matrix[r].length; c++)
            {
                System.out.printf("%4d", matrix[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

}