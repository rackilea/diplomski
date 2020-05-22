public int compare(String A, String B)
{
    String[] as = A.split(",");
    String[] bs = B.split(",");

    for(int i = 4; i >= 1; i--) //columns d-a
    {
        int a = Integer.parseInt(a[i]);
        int b = Integer.parseInt(b[i]);
        if(a < b)
            return -1;
        if(a > b)
            return 1;
    }
    return 0;
}