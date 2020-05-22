/**
 * Read property from underlying map.
 *
 * @param key key to use for mapping
 *
 * @return object associated with the given configuration key.
 */
public Object getProperty(String key)
{
    return store.get(key);
}