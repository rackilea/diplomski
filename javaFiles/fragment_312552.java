public class NumberParser
{
    public static void parseData(String resourceName)
    {
        Scanner s = new Scanner(NumberParser.class.getResourceAsStream(
             resourceName));

        double [] x = new double[3];
        double [] y = new double[3];
        int [] z = new int[3];

        for (int i = 0; i < 3; i++)
        {
            x[i] = s.nextDouble();
            y[i] = s.nextDouble();
            z[i] = s.nextInt();
        }

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
    }

    public static void main(String[] args)
    {
        parseData("numbers.txt");
    }
}