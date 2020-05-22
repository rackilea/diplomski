Things key = new Things(thing1, thing2);
if (!cache.contains(key) {
    Integer result = computeResult();
    cache.put(key, result);
    return result;
} else {
    return cache.getValue(key);
}