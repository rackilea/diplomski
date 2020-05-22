int n;
//Take n which is number of nodes here
Pair[] input=new Pair[n];
for(int i=0;i<n;i++)
{
    input[i]=new Pair(*input value*, *input Position*);
}

Arrays.sort(input, new Comparator<Book>() //Sorts by the distance from start node
{
    @Override
    public int compare(Pair p1, Pair p2)
    {
        return p1.pos.length()-p2.pos.length();
    }
});