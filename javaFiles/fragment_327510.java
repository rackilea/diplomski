public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    in.useDelimiter("\n");
    char[] text = in.next().toCharArray();

    int start = 0;
    int end = 0;
    ArrayList<Integer[]> list = new ArrayList<Integer[]>();
    for( ;start<text.length; start++)
    {
        for(end=start; end<=start+1; end++)
        {
            list.add(grow(text, start, end));
        }
    }
    for(Integer[] v: list)
        System.out.println(v[0] +" : "+v[1]);
    findmax(list);
}
static Integer[] grow(char[] text, int start, int end)
{
    while(start>0 && end < text.length && text[start-1]==text[end])
    {
        start--;
        end++;
    }
    return new Integer[]{start, end};
}
static void findmax(ArrayList<Integer[]> list)
{
    int i=0; int j=0;
    for(Integer[] v: list)
    {
        if(v[1]-v[0]>j-i)
        {
            i = v[0];
            j = v[1];
        }
    }
    System.out.println(i+" "+j);
}