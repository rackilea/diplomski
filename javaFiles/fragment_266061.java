return enumWords.stream()
     // filter when they are different
     .filter(word -> m1.get(word) != m2.get(word))
     // stop search at first occurrence
     .findFirst()
     // compare and get the value 1 or -1
     .map(word -> m1.get(word).compareTo(m2.get(word)))
     // return the value or 0 in case is not found
     .orElse(0);