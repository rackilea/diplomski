map.computeIfPresent(k, (key, value) -> {
    //process the value here
    //key is k
    //value is the value to which k is mapped.

    return null; //return null to remove the value after processing.
});