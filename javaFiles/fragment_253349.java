int [][] a = new int [5][2];
for(int i = 0; i < 5; i++ )
{
    System.out.println( "Month number (e.g. August = 8)" );
    int month = StdIn.readInt();
    a[i][0] = month;

    System.out.println( "Year number (e.g. 2007)" );                
    int year = StdIn.readInt();
    a[i][1] = year;

}