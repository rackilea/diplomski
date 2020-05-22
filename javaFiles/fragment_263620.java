public String rubbish(String input)
{
    String result = "";

    long seed = 0;
    long size = 0;

    for(int i = 0; i < input.length(); i ++)
    {
        seed += input.charAt(i);
    }

    seed %= Long.MAX_VALUE;
    size = seed % 3000;

    Random rand = new Random(seed);

    for(int i = 0; i < size; i ++)
    {
        result += (char)rand.nextInt(256);
    }

    return result;
}