AtomicReference<Object> cache = new AtomicReference<Object>();

Object cachedValue = new Object();
cache.set(cachedValue);

//... time passes ...
Object cachedValueToUpdate = cache.get();
//... do some work to transform cachedValueToUpdate into a new version
Object newValue = someFunctionOfOld(cachedValueToUpdate);
boolean success = cache.compareAndSet(cachedValue,cachedValueToUpdate);