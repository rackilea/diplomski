TestHazelcastFactory testHazelcastFactory = new TestHazelcastFactory();

    HazelcastInstance member = testHazelcastFactory.newHazelcastInstance();
    IMap<Object, Object> testMap1 = member.getMap("test");
    testMap1.put(1, "test");

    HazelcastInstance client = testHazelcastFactory.newHazelcastClient();
    IMap<Object, Object> testMap2 = client.getMap("test");
    Object o = testMap2.get(1);
    System.out.println("o = " + o);