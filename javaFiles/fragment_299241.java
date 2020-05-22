final double cacheSizeInGB = 1.0;

        // Create cache backed by off-heap store
        // In this case store will use ByteBuffers backed by byte[].
        HTreeMap cache = DBMaker
                .memoryDirectDB()
                .transactionDisable()
                .make()
                .hashMapCreate("test")
                .expireStoreSize(cacheSizeInGB) //TODO not sure this actually works
                .make();

        //generates random key and values
        Random r = new Random();
        //used to print store statistics
        Store store = Store.forEngine(cache.getEngine());


        // insert some stuff in cycle
        for(long counter=1; counter<1e8; counter++){
            long key = r.nextLong();
            byte[] value = new byte[1000];
            r.nextBytes(value);

            cache.put(key,value);

            if(counter%1e5==0){
                System.out.printf("Map size: %,d, counter %,d, store size: %,d, store free size: %,d\n",
                        cache.sizeLong(), counter, store.getCurrSize(),  store.getFreeSize());
            }

        }

        // and release memory. Only necessary with `DBMaker.memoryDirect()`
        cache.close();