public MyClass(int a, int b, int c)
{
    if(c != 1 && c != 2)
        throw new ArgumentException(...);
    ...
}