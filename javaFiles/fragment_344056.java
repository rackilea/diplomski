import java.util.Scanner;

public class GradeSO
{
    Scanner input = new Scanner(System. in);

    int remainder;
    int down;
    int column;
    int row;

    int rows = 5;
    int columns = 5;
    int one;
    int two;

    int[][] grid;

    public void makeLocation(int x, int r, int c)
    {
        remainder = x % c;
        down = (int) x / r;

        if(x % c!=0)
        {
            column = remainder-1;
        }
        else
        {
            column = remainder;
        }

        if(x % c==0)
        {
            row=down-1;
            column = remainder+4;
        }
        else
        {
            row=down;
        }
    }

    public void makeArray()
    {
        grid = new int[rows][columns];

        System.out.println("Player 1: Please chose a number between 1 and 25");
        one = input.nextInt();

        while (one > 25 || one < 1)
        {
            System.out.println("Error: Invalid Number");
            System.out.println("Player 1: Please enter a number between 1 and 25");
            while (!input.hasNextInt()) {
                input.next();
            }
            one = input.nextInt();
        }

        makeLocation(one,columns,rows);
        grid[row][column]= 1;

        System.out.println("Player 2: Please chose a number between 1 and 25");
        two = input.nextInt();

        while (two > 25 || two < 1)
        {
            System.out.println("Error: Invalid Number");
            System.out.println("Player 2: Please enter a number between 1 and 25");
            while (!input.hasNextInt()) {
                input.next();
            }
            two = input.nextInt();
        }

        makeLocation(two,columns,rows);
        grid[row][column]= 2;
    }

    public void displayArray()
    {
        for (int[] smallGrid: grid) 
        {
            for (int elem: smallGrid) 
            {
                System.out.print(elem);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        GradeSO gSO = new GradeSO();
        gSO.makeArray();
        gSO.displayArray();
    }
}