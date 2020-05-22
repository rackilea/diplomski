Map<Pair,Integer> histogram = new HashMap<Pair,Integer>();
for(Task task : tasksByGroupAndUser) {
   if (task.isSuccessful() == false) continue; //just skip unseccessful tasks.
   Pair current = new Pair(task.getUser(),task.getGroup());
   Integer value = histogram.get(current);
   histogram.put(current, value == null? 1 : value + 1); //update the histogram
}
for (Entry<Pair,Integer> entry : histogram.entrySet()) { 
   updateUser(entry.getKey().getUser(),entry.getKey().getGroup(),entry.getValue());
}