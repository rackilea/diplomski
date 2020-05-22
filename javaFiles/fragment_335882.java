public static IntegerSet union(IntegerSet otherSet, IntegerSet nextSet) {
      for(int i=0; i<otherSet.length(); i++) {
           if (otherSet.isSet(i))
                nextSet.insertElement(i);
           }
           return nextSet;
      }