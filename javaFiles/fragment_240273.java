DB dbDisk = DBMaker
        .fileDB(file)
        .make();

DB dbMemory = DBMaker
        .memoryDB()
        .make();

// Big map populated with data expired from cache
HTreeMap onDisk = dbDisk
        .hashMap("onDisk")
        .create();

// fast in-memory collection with limited size
HTreeMap inMemory = dbMemory
        .hashMap("inMemory")
        .expireAfterGet(1, TimeUnit.SECONDS)
        //this registers overflow to `onDisk`
        .expireOverflow(onDisk)
        //good idea is to enable background expiration
        .expireExecutor(Executors.newScheduledThreadPool(2))
        .create();