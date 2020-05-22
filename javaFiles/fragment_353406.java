public int count(ArrayList<Integer> arraylist)
{
    int a = Collections.min(arraylist);
    int count = arraylist.indexOf(a);
    return count;
}