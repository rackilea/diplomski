Resource resource = pool.getResource();
try {
    ... 
    // do stuff
    ...
} finally {
    pool.releaseResource(resource);
}