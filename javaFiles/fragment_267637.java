public static void main(String[] args)
{
    int seed = 1200;
    int maxOutput = 25;

    // 50 flips, 25 length max, including ... if needed
    StringBuilder res = doFlips(50, new Random(seed));
    System.out.println(ourChop(res, maxOutput));

    res = doFlips(60, new Random(seed));
    System.out.println(ourChop(res, maxOutput));