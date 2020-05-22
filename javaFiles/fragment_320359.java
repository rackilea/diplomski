SortedMap<String,String> map =
        new TreeMap<String,String>(secondCharComparator);
    map.put("Za", "FOO");
    map.put("Ab", "BAR");
    map.put("00", "ZERO");
    System.out.println(map); // prints "{00=ZERO, Za=FOO, Ab=BAR}"