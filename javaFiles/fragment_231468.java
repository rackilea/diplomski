public E next() {
        checkForComodification(); // will throw ConcurrentModificationException
                                  // before the Iterator's state is changed
        try {
            int i = cursor;
            E next = get(i);
            lastRet = i;
            cursor = i + 1;
            return next;
        } catch (IndexOutOfBoundsException e) {
            checkForComodification();
            throw new NoSuchElementException();
        }
    }