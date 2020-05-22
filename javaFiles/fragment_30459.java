A a = new A();
a.setId(1);
a.setLastUpdate(new Date());
a.setVersion(1);

Map<String, String> myMap = new HashMap<>();
myMap.put("b", "");
a.setMyMapping(myMap);

em.getTransaction().begin();
em.persist(a);
em.getTransaction().commit();
em.clear();