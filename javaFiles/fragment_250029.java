class Main
{
    public static void main(String[] args)
    {
        System.out.println(hasteen(22, 28, 32));
    }

    public static boolean hasteen(int age1, int age2, int age3)
    {
        if (
                (age1 >= 13 && age1 <= 19) ||
                (age2 >= 13 && age2 <= 19) ||
                (age3 >= 13 && age3 <= 19)
           )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}