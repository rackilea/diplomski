static List<Integer> int2List(int l, int base)
{
    List<Integer> list = new ArrayList<Integer>();
    int n;
    l++;
    while(l > 0)
    {
       n = (l-1) % base;
       list.add(0, (int) n+1);
       l = (l-n)/base; 
    }
    return list;
}