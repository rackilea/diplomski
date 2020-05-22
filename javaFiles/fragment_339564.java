final Iterator<Student> iter = Iterators.peekingIterator(Students.iterator());

final Student a = iter.peek();
final Student b = iter.peek();
final Student c = iter.next();

assert a == b == c;