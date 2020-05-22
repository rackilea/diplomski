import java.util.Arrays;
public class scratch
{

    public static void main(String[] args)
    {
        int[][][] cube;
        cube = new int[2][2][2];
        cube[0][0][0] = 4;
        cube[0][0][1] = 2;
        int[] test = new int[]{4, 2};
        for (int i = 0; i < test.length; i++)
            System.out.println(cube[0][0][i] + " " + test[i]); //Printing test
        if (Arrays.equals(cube[0][0], new int[]{4, 2})) //Returns true
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}