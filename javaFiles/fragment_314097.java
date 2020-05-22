List<List<Integer>> lists = ...
Collection<Integer> common = new HashSet<Integer>(lists.get(0));
for (int i = 1; i < lists.size(); i++) {
   if (!lists.get(i).isEmpty()) 
     common.retainAll(lists.get(i));
}