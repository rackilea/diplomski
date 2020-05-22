public static int squareSum(const List<Integer> values)
{
    int total = 0;
    for(int e : values) {
        total += e * 2;  // mutates a local variable
    }
    return total;
}