public static void main( String[] args )
{

    int a;
    int b;

    //pattern 1
    for (a = 1; a <= 10; a++)
    {
        for (b = 1; b <= a; b++)
        {
            System.out.print("*");//this creates each column

        }
        System.out.println();/*
                              * this marks the end of a row and brings the
                              * asterisks down to the next line
                              */
    }

    //pattern2
    for (a = 1; a <= 10; a++)
    {
        for (b = 1; b <= 11 - a; b++)
        {
            System.out.print("*");//this creates each column

        }
        System.out.println();/*
                              * this marks the end of a row and brings the
                              * asterisks down to the next line
                              */
    }
}