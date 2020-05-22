List foo = new ArrayList();
foo.add("Foo!");

for(Iterator i = foo.iterator(); i.hasNext(); )
{
    Object element = i.next();

    System.out.println((String)element);
}