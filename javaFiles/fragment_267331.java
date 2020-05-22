private final ConcurrentHashMap<String, AtomicReference<Object>> cache = 
           new ConcurrentHashMap<>();

public List<Tag> getCachedTags() throws Exception 
    AtomicReference<Object> ref = cache.get(key);
    if(ref == null) {
        ref = new AtomicReference<>();
        AtomicReference<Object> oldRef = cache.putIfAbsent(key, ref);
        if(oldRef != null) {
            ref = oldRef;
        }
        synchronized(ref) {
            if(ref.get() == null) {
                ref.set(iTagService.getTags(null));
            }
        }
    }
    return (List<Tag>)ref.get();
}