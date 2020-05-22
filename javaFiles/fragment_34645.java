private static char[][] arr;


public static void populate(int start,int N)
{
    //System.out.println(start+" "+N);
    if(N < 0 || start > N)
        return;

    for (int i = start; i < N; i++)
    {
        for (int j = start; j < N; j++)
        {
            if(i==start || i==N-1 || j==start || j==N-1)
                arr[i][j]='*';
            else
                arr[i][j]=' ';
        }
    }

    populate(start+2,N-2);
}

public static void print()
{
    for (int i = 0; i < arr.length; i++)
    {
        for (int j = 0; j < arr.length; j++)
        {
            System.out.print(arr[i][j]);
        }
        System.out.println();
    }
}

/**
 * @Method :main is Personal Method Of Class-->SquaresInSquare
 * @returns : void
 * @param args
 */
public static void main(String[] args)
{
    int N=21;
    arr=new char[N][N];
    populate(0,N);
    print();

}