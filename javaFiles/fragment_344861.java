Map<String, ForexPair> map = new HashMap<String, ForexPair>();

...

// in the for-loop:
map.put(pairNames[i], new ForexPair(pairNames[i], myArray[i][1],myArray[i][2]));