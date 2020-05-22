public static boolean check(String s1,String s2)
{
    boolean result = false;

    if(s1.length() >= s2.length())
    {
        result = compare(s1, s2);
    }
    else
    {
        result = compare(s2,s1);
    }


    return  result;
}

public static boolean compare(String s1,String s2)
{
    boolean result = false;
    char[] array1 = s1.toCharArray();
    char[] array2 = s2.toCharArray();
    if(array1.length>=array2.length)
    {
        int j = array2.length-1;
        for(int i = array1.length-1;i>=0;i--,j--)
        {
            if(j==0)
            {
                if(!(array1[i]==array2[j]))
                {
                    break;
                }
                else
                {
                    result = true;
                    break;
                }
            }
            else
            {
                if(!(array1[i]==array2[j]))
                {
                    break;
                }
            }
        }
    }

    return result;

}