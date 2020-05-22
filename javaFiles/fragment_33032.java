public static int squareSum(const List<Integer> values)
{
    return values.stream()
           .map(e-> e*2)
           .reduce(0, (c, e)-> c + e);
}