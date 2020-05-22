public class BinaryNumber 
{
    public static String binaryNumber( int j)       
    {

        String n = "";
        String a = "";


        do
        {
            a += (j % 2);
            j = j/2;         

        }while (j != 0);

        for(int r = (a.length() - 1); r >=0; r--)
         {
            n += a.charAt(r);
         }

        return n;
    }
}