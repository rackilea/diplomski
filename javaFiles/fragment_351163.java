LoadingCache<String, WorkerItem> cache = CacheBuilder.newBuilder()
.concurrencyLevel(level) 
.maximumSize(size)
.expireAfterWrite(seconds, TimeUnit.SECONDS)
.removalListener(this)
.build(
    new CacheLoader<String, WorkerItem>() {
        public WorkerItem load(String key) throws Exception {
            WorkerItem workerItem = new MoreSpecificWorkerItem();
            workerItem.setTask(key);
            Controller.beginWorking(workerItem); //Runs in thread pool
            return workerItem;
        }
    }
);