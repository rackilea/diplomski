import java.util.Arrays;

public class StaircaseSteps
{
    public static void main(String[] args)
    {
        for (int i = 5; i < 33; i++)
        {
            runStaircase(i);
            runSteps(i);
            runDynamic(i);
        }
    }

    private static void runStaircase(int max)
    {
        long before = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < max; i++)
        {
            sum += Staircase.counting(i);
        }
        long after = System.nanoTime();
        System.out.println("Staircase  up to "+max+" gives "+sum+" time "+(after-before)/1e6);
    }

    private static void runSteps(int max)
    {
        long before = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < max; i++)
        {
            sum += Steps.step(i);
        }
        long after = System.nanoTime();
        System.out.println("Steps      up to "+max+" gives "+sum+" time "+(after-before)/1e6);
    }

    private static void runDynamic(int max)
    {
        long before = System.nanoTime();
        long sum = 0;
        for (int i = 0; i < max; i++)
        {
            sum += StaircaseDynamicProgramming.counting(i);
        }
        long after = System.nanoTime();
        System.out.println("Dynamic    up to "+max+" gives "+sum+" time "+(after-before)/1e6);
    }
}

class Staircase
{
    public static int counting(int n)
    {
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        else
            return counting(n - 1) + counting(n - 2) + counting(n - 3);
    }
}




class Steps
{
    static int c2 = 0;
    static int stairs;

    public static int step(int c)
    {
        c2 = 0;
        stairs = c;
        return step2(0);
    }

    private static int step2(int c)
    {
        if (c + 1 < stairs)
        {
            if (c + 2 <= stairs)
            {
                if (c + 3 <= stairs)
                {
                    step2(c + 3);
                }
                step2(c + 2);
            }
            step2(c + 1);
        }
        else
        {
            c2++;
        }
        return c2;
    }
}


class StaircaseDynamicProgramming
{
    public static int counting(int n)
    {
        int results[] = new int[n+1];
        Arrays.fill(results, -1);
        return counting(n, results);
    }

    private static int counting(int n, int results[])
    {
        int result = results[n];
        if (result == -1)
        {
            result = 0;
            if (n >= 1) 
            {
                result += counting(n-1, results);
                if (n >= 2) 
                {
                    result += counting(n-2, results);
                    if (n >= 3) 
                    {
                        result += counting(n-3, results);
                    }
                }
            }
            else
            {
                result += 1;
            }
        }
        results[n] = result;
        return result;
    }
}