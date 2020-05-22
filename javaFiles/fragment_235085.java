LinkedList<SomeType> list = ...
    SomeType a, b = ..

    // Insert 'b' before the first element equal to 'a' in 'list'
    ListIterator<SomeType> iterator = list.listIterator(0);
    while (iterator.hasNext()) {
        SomeType e = iterator.next();
        if (e.equals(a)) {
            iterator.previous();  // returns 'e' again.  But the real purpose
                                  // is to reset the iteration position
                                  // so that 'next()' would return 'e' again.
            iterator.add(b);      // inserts before 'next()'.
            break;
        }
    }