public int count(ArrayList<Integer> arraylist)
{
    int count = 0;
    int flag = 0;
    for(int i = 0 ; i < arraylist.size() - 1; i++)
    if(arraylist.get(i) > arraylist.get(i+1))
    {
        count++;
        flag = 1;
        break;
    }
    else
    {
        count++;
    }
    if(flag == 0)
    {
        count = 0;
    }
    return count;
}