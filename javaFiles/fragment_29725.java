@Autowired    
EhCacheCacheManager ehCacheCacheManager; 
...
//in the infinite loop
            List keys = ((Ehcache) ehCacheCacheManager.getCache("test").getNative                Cache()).getKeys();
            for (int i = 0; i < keys.size(); i++) {
                Object o = keys.get(i);
                Ehcache ehcache = (Ehcache)ehCacheCacheManager.getCache("test").getNativeCache()
                Element item = (ehcache).get(o);

                //get the data based on some info in the value, and if no exceptions         
                ehcache.put(new Element(element.getKey(), newValue));

            }