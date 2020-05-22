public static void main(final String[] args)
{
    double position = 0;
    for (int i = 0; i < 100; i++)
    {
        position = (position + 10) * 1.1;
        System.out.println("position = " + position);
    }
}