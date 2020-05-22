Cache testCache = new Cache(new CacheConfiguration("http", 100000)
.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)
.eternal(false)
.timeToLiveSeconds(60)
.timeToIdleSeconds(30)
.diskExpiryThreadIntervalSeconds(0)
//Persist everything and keep it on restart
.persistence(new PersistenceConfiguration().strategy(Strategy.LOCALRESTARTABLE)));