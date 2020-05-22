public static void foo(int i)
{
    if(i>=N) return; // stack too deep

    foo(i+1);
    foo(i+1);
}