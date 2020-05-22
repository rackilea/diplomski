List<String> foo = new ArrayList();
foo.add("Foo!");

for(Iterator<String> i = foo.iterator(); i.hasNext(); )
{
    String element = i.next();

    System.out.println(element);
}