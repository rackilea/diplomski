int firstDuplicate(int[] a) 
{
    Set<Integer> set = new HashSet<>();
    for(int i=0;i<a.length;i++){
        if(!set.add(a[i])) {
            return a[i];
        }
    }
    return -1; // no duplicates found 
}