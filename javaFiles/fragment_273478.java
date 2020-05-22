public static boolean deleteValues(ArrayList<Integer> list, int item)
{
    int p = list.indexOf(item);
    if(p<0)
        return false;
    for(int i=0; i<list.size();) {
        if (list.get(i) < item) {
            list.remove(i);
        } else {
            i++;
        }
    }
    return true;   
}