public static IntegerSet union(IntegerSet otherSet, IntegerSet nextSet) {

    for(int i=0; i<a.length; i++) {
      if (otherSet.isSet(i))
        nextSet.insertElement(i);
    }

    return nextSet;
  }

  public static IntegerSet intersection(IntegerSet otherSet, IntegerSet nextSet) {

    for(int i=0; i<a.length; i++) {
      if (!otherSet.isSet(i))
        nextSet.deleteElement(i);
    }

    return nextSet;
  }