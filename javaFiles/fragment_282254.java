@RequestMapping
public ResponseEntity<...> findByGpnPrefixCacheable(WebRequest request) {

    // 1. application-specific calculations with full/partial data
    long lastModified = ...; 
    String etag = ...;

    if (request.checkNotModified(lastModified, etag)) {
        // 2. shortcut exit - no further processing necessary
        //  it will also convert the response to an 304 Not Modified
        //  with an empty body
        return null;
    }

    // 3. or otherwise further request processing, actually preparing content
    return ...;
}