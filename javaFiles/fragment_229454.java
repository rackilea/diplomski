// on-heap pool configuration
Pool onHeapPool;
if (configuration.getMaxBytesLocalHeap() > 0) {
    PoolEvictor evictor = new FromLargestCachePoolEvictor();
    SizeOfEngine sizeOfEngine = cacheManager.createSizeOfEngine(this);
    onHeapPool = new BoundedPool(configuration.getMaxBytesLocalHeap(), evictor, sizeOfEngine);
} else if (getCacheManager() != null && getCacheManager().getConfiguration().isMaxBytesLocalHeapSet()) {
    onHeapPool = getCacheManager().getOnHeapPool();
} else {
    onHeapPool = new UnboundedPool();
}