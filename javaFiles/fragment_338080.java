final class FooList extends AbstractList implements ...
{
    private Object[] tab;
    ...
}

public ListIterator listIterator() {...}

public int bar(int x, Collection c) {...}

for (Iterator it = s.baz(x).iterator(); it.hasNext();) {
  final Foo f = (Foo) it.next();
  ...
}

for (Iterator it = p.entrySet().iterator(); it.hasNext();) {
  final Map.Entry e = (Map.Entry) it.next();
  ...
}