private final ConcurrentHashMap<String, Object> cache = new ConcurrentHashMap<>();

public List<Tag> getCachedTags() throws Exception 
    List<Tag> tags = (List<Tag>)cache.computeIfAbsent(Config.tagCacheKey, 
      k -> iTagService.getTags(null));

    return tags;
}