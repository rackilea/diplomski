public static void main(final String[] args)
{
    final MyType<Integer> myType1 = create();
    myType1.v = 1;
    final MyType<String> myType2 = create();
    myType2.v = "1";
    System.out.print(myType1);
    System.out.print(myType2);
}

public static class MyType<T>
{
    T v;
}

public static <K> MyType<K> create()
{
    return new MyType<>();
}