LinkedHashMap<String, Integer> b = new LinkedHashMap<String,Integer>();

    b.put("one",1);
    b.put("two",2);
    b.put("a",3);

    for (String key:b.keySet())
    {
        System.out.println(b.get(key));    // print 1 then 2 finally 3
    }