for (k = 0; k < 50; k++)
{
    for ( i = k; i < 50; i++)
    {
        for ( j = i; j < 50; j++)
        {
            if ( (k+1)*(k+1) + (i+1)*(i+1) == (j+1)*(j+1) )
            {
                System.out.println( "\n\n\t\tThe numbers are : " + (k+1) + ", "
                                                                 + (i+1) + ", "
                                                                 + (j+1) );
            }
        }
    }
}