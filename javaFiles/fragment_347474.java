public class CustomComparator implements Comparator<String>
{
    public int compare(String A, String B)
    {
        String[] as = A.split(",");
        String[] bs = B.split(",");

        int a = Integer.parseInt(a[4]); //column d, as an int
        int b = Integer.parseInt(b[4]);
        if(a < b)
            return 1;
        else
            if(a > b)
                return -1;
            else
            {
                a = Integer.parseInt(a[3]); //column c, as an int
                b = Integer.parseInt(b[3]);
                if(a < b)
                    return -1;
                else
                    if(a > b)
                        return 1;
                    else
                    {
                        a = Integer.parseInt(a[2]); //column b, as an int
                        b = Integer.parseInt(b[2]);
                        if(a < b)
                            return -1;
                        else
                            if(a > b)
                                return 1;
                            else
                            {
                                a = Integer.parseInt(a[1]); //column a, as an int
                                b = Integer.parseInt(b[1]);
                                if(a < b)
                                    return -1;
                                else
                                    if(a > b)
                                        return 1;
                                    else
                                        return 0; //all columns are the same
                            }
                    }
            }
    }
}