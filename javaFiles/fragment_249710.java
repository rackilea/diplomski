TermComparator termComparator = new TermComparator();
    TreeMap<DictionaryTerm, Integer> miniDictionary = new TreeMap<>(termComparator);
    miniDictionary.put(new DictionaryTerm("LedZeppelin", 55), 25);

    DictionaryTerm  aTerm = new DictionaryTerm("LedZeppelin",100);
    DictionaryTerm floorKey = miniDictionary.floorKey(aTerm);
    if (floorKey != null && termComparator.compare(aTerm, floorKey) == 0) {
        System.out.println(floorKey.getNumber()); // prints 55
    }