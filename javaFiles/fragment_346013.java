if (freeObjects.isEmpty()) {
    // The pool is empty, create a new object.
    object = factory.createObject();
} else {
    // The pool is non-empty, retrieve an object from the pool and return it.
    object = freeObjects.remove(freeObjects.size() - 1);
}