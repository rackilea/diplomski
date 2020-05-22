class ImmutableStack<T>
{
    public readonly T Head;
    public readonly ImmutableStack<T> Tail;

    public ImmutableStack(T head, ImmutableStack<T> tail)
    {
        this.Head = head;
        this.Tail = tail;
    }

    public static ImmutableStack<T> Cons(T head, ImmutableStack<T> tail)
    {
        return new ImmutableStack<T>(head, tail);
    }

    public static ImmutableStack<T> Reverse(ImmutableStack<T> s)
    {
        ImmutableStack<T> res = null;
        while (s != null)
        {
            res = Cons(s.Head, res);
            s = s.Tail;
        }
        return res;
    }
}

class Program
{
    static void AwesomeRecursion(int toDepth, int start, int max, ImmutableStack<int> indices)
    {
        if (toDepth < 0)
        {
            throw new ArgumentException("toDepth should be >= 0");
        }
        else if (toDepth == 0)
        {
            Console.Write("indices: ");
            indices = ImmutableStack<int>.Reverse(indices);
            while (indices != null)
            {
                Console.Write("{0}, ", indices.Head);
                indices = indices.Tail;
            }
            Console.WriteLine();
        }
        else
        {
            for (int i = start; i < max; i++)
            {
                AwesomeRecursion(toDepth - 1, i + 1, max, ImmutableStack<int>.Cons(i, indices));
            }
        }
    }


    static void Main(string[] args)
    {
        AwesomeRecursion(4, 1, 10, null);
        Console.WriteLine("Done");
        Console.ReadKey(true);
    }
}