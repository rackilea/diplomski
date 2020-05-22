@SafeVarargs
static <E> E[] newArray(int length, E... array)
{
    return Arrays.copyOf(array, length);
}

List<String>[] array1 = newArray(10);