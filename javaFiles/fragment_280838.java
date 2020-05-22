class Test
{
    public static void main(String[] myArgs) throws NumberFormatException
    {
        String myString = "42";
        int myInt = Integer.parseInt(myString);
        double myDouble = (double)myInt * 42.0d;
        System.out.println(myDouble);
    }
}