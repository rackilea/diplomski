@SafeVarargs
static <E> E[] array(E... array)
{
    return array;
}

List<String>[] array2 = array( list1, list2 );