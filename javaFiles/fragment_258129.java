public static void main(String[] args)
{
    //final int it = 5;
    int size;
    size = 5;

    for( int i = 1;  i < size; ++i)
    {
        String star = "";
        for (int p = size; p > i; --p)
        {
            star += "\t";
        }
        for (int j = 0; j < i; ++j)
        {
            star += "*\t\t";
        }

        System.out.println(star);


    }

}