class IntegerComparator implements Comparator<Integer> { ... }

// 'c' is a raw Comparator, or effectively a Comparator<Object>
// (note the lack of type arguments).
Comparator c = new IntegerComparator();
int result = c.compare(1, "hello");