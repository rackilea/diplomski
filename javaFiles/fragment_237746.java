Map<Integer,String> map = new HashMap<Integer,String>();
map.put(1, "One");
map.put(2, "Two");
map.put(10, "Ten");
...

int n = ... // some number
String s = map.get(n);
if(s == null)
   System.out.println("No entry was found for " + n);
else
   System.out.println(n + " is " + s);