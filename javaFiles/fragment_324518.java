// Nope 
public static Set<Object> union(Set<Object> s1, Set<Object> s2) {
  Set<Object> result = new HashSet<Object>(s1);
  result.addAll(s2);
  return result;
}