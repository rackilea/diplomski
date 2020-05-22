/**
  * Returns a view of the entries stored in this cache as a synchronous {@link Cache}. A mapping is
  * not present if the value is currently being loaded. Modifications made to the synchronous cache
  * directly affect the asynchronous cache. If a modification is made to a mapping that is
  * currently loading, the operation blocks until the computation completes.
  *
  * @return a thread-safe synchronous view of this cache
  */
Cache<K, V> synchronous();