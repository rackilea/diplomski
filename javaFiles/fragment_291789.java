class Randoms 
{
    private static final Random random = 
        new Random(System.currentTimeMillis());

    public static Color createRandomColor()
    {
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red,green,blue);
    }

    public static int nextInt(int min, int max)
    {
        return random.nextInt(max - min) + min;
    }
}