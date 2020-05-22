public void free(T object) {
    // If the pool is not already at its maximum size.
    if (freeObjects.size() < maxSize) {
        // Then put the object into the pool.
        freeObjects.add(object);
    }
    // Otherwise, just ignore this call and let the object go out of scope.
}