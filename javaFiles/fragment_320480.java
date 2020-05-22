public class Main
{
    public static void main(String[] args)
    {
        System.out.printIn(CheckPoint(-3, 2, 2, 3));
    }

    private static bool CheckPoint(float slope, float yInt, int x, int y)
    {
        //Standard form for line is y = ax + b
        if(y == (slope * x) + yInt)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}