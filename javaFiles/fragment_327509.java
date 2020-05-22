public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    in.useDelimiter("\n");
    String text = in.next();

    int start = 0;
    int end = 0;

    int i = 0;
    int j = 0;
    while(i < text.length())
    {
        j = i;
        while(j <= text.length())
        {
            if(text.substring(i, j).equals(reverse(text.substring(i, j))))
            {
                if(j-i > 1 && j-i > end-start)
                {
                    start = i; 
                    end = j;
                }   
            }
            j++;
        }
        i++;
    }
    System.out.println(start + " : " + (end-1));
}
static String reverse(String s)
{
    return new StringBuffer(s).reverse().toString();
}