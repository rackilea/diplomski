public class Fibonacci
{
    public static long fib(int n)
    {
        long current = 0;
        long next = 1;
        for(int i = 0; i < n/2; i++)
        {
            current += next;
            next += current;
        }
        return n % 2 == 0 ? current : next;
    }
    public static List<Long> fibList(int n)
    {
        List<Long> ret = new ArrayList<>(n == 0 ? List.of(0L) : List.of(0L, 1L));
        long current = 0;
        long next = 1;
        for(int i = 0; i < n/2; i++)
        {
            current += next;
            next += current;
            if(i*2+1 <= n)
                ret.add(current);
            if(i*2+2 < n)
                ret.add(next);
        }
        return ret;
    }
}