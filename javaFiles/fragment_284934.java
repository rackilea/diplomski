public interface CacheEvictionService {
    /**
     * Adds the provided key to a global list of keys that we'll need later for eviction
     *
     * @param key the cached key for any entry
     */
    void addKeyToList(String key);

    /**
     * Find keys that contain the partial key
     *
     * @param partialKey the cached partial key for an entry
     * @return List of matching keys
     */
    List<String> findKeyByPartialKey(String partialKey);

    /**
     * Evicts the cache and key for an entry matching the provided key
     *
     * @param key the key of the entry you want to evict
     */
    void evict(String key);

}

@Service
public class CacheEvictionServiceImpl implements CacheEvictionService {
    LinkedHashSet<String> cachedKeys = new LinkedHashSet<>();

    @Override
    public void addKeyToList(String key) {
        this.cachedKeys.add(key);
    }

    @Override
    public List<String> findKeyByPartialKey(String partialKey) {
        List<String> foundKeys = new ArrayList<>();
        for (String cachedKey : this.cachedKeys) {
            if (cachedKey.contains(partialKey)) {
                foundKeys.add(cachedKey);
            }
        }
        return foundKeys;
    }

    @Override
    @CacheEvict(value = {"valueCodes", "fieldCodes", "qi", "fieldNames", "fieldsByType"}, key = "#key")
    public void evict(String key) {
        this.cachedKeys.remove(key);
    }
}