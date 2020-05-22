MultiKeyMap multiKeyMap = new MultiKeyMap();

multiKeyMap.put("Key 1A","Key 1B","Value 1");
multiKeyMap.put("Key 2A","Key 2B","Value 2");
multiKeyMap.put("Key 3A","Key 3B","Value 3");

MapIterator it = multiKeyMap.mapIterator();

while (it.hasNext()) {
    it.next();

    MultiKey mk = (MultiKey) it.getKey();

    // Option 1
    System.out.println(mk.getKey(0));
    System.out.println(mk.getKey(1));

    // Option 2
    for (Object subkey : mk.getKeys())
      System.out.println(subkey);

    System.out.println(it.getValue());
}