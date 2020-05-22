/* Set whether to use the HTTP 1.1 cache-control header. Default is "true".
 * <p>Note: Cache headers will only get applied if caching is enabled
 * (or explicitly prevented) for the current request. */
public final void setUseCacheControlHeader();

/* Return whether the HTTP 1.1 cache-control header is used. */
public final boolean isUseCacheControlHeader();

/* Set whether to use the HTTP 1.1 cache-control header value "no-store"
 * when preventing caching. Default is "true". */
public final void setUseCacheControlNoStore(boolean useCacheControlNoStore);

/* Cache content for the given number of seconds. Default is -1,
 * indicating no generation of cache-related headers.
 * Only if this is set to 0 (no cache) or a positive value (cache for
 * this many seconds) will this class generate cache headers.
 * The headers can be overwritten by subclasses, before content is generated. */
public final void setCacheSeconds(int seconds);