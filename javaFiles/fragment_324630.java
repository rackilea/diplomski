Set<String> set = new HashSet<String>();
int n = set.size();
Object o = new Object();
if (!(n != 1 && set.contains(o))) {
  System.out.println("Foo");
  // Do stuff...
}