CacheManager.getInstance().addCache("xyz"); // creates a cache called xyz.

Cache xyz = CacheManager.getInstance().getCache("xyz");

xyz.put(new Element("key", new Person()));
Element e = xyz.get("key");
Person p = (Person) e.getObjectValue();