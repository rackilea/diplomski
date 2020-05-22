<T extends List<?>> void foo(T... args)
{
    List<String>[] array2 = (List<String>[])args;
    array2[0] = a_list_of_string;
}

void test2()
{
    List<Integer>[] args = ...;   // [1]
    foo(args);
    Integer i = args[0].get(0);   // [2]
}