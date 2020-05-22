List<MyObject> l = new ArrayList<MyObject>();
...
try {
int a = sum(l,"x");
System.out.print(a);
} catch (IllegalAccessException e) {
...