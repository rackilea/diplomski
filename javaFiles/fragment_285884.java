List<Foo> foos = ...;
for (Foo foo : foos)
{
    foo.bar();
}

// equivalent to:
List<Foo> foos = ...;
for (Iterator<Foo> iter = foos.iterator(); iter.hasNext();)
{
    Foo foo = iter.next();
    foo.bar();
}