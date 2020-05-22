List<String> c = new ArrayList<String>();
c.add("Item 1");
c.add("Item 2");
c.add("Item 3");
...
for (Iterator<String> i = c.iterator(); i.hasNext();)
{
  String s = i.next();
  ...
}