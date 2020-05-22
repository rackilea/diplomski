static long SumSubtring(String s)
{
    long sum = 0, mult = 1;
    for (int i = s.Length; i > 0; i--, mult = mult * 10 + 1)
        sum += (s[i - 1] - '0') * mult * i;
    return sum;
}