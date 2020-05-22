public boolean levelTwoFriends(Integer user1, Integer user2) { 
  Collection<Integer> c = graph.get(user1);
  // c.retainAll(graph.get(user2)); 
  // return !c.isEmpty(); 

  // true only if a non-void intersection
  return false==Collections.disjoint(c, graph.get(user2));
}