List<Integer> list = ...;
Set<Integer> set = new HashSet<Integer>(list);

if(set.size() < list.size()){
    /* There are duplicates */
}