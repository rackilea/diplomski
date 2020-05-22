CacheConfiguration<Integer, BinaryObject> cachecfg = new CacheConfiguration<>();

    QueryEntity e = new QueryEntity();
    e.setKeyType("java.lang.Integer");
    e.setValueType("BinaryTest");

    LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
    map.put("name", "java.lang.String");
    e.setFields(map);

    ArrayList<QueryEntity> list = new ArrayList<QueryEntity>();
    list.add(e);
    cachecfg.setQueryEntities(list);
    cachecfg.setName("MY_CACHE");
    IgniteCache<Integer, BinaryObject> ignitecache = igniteInstance.createCache(cachecfg).withKeepBinary();