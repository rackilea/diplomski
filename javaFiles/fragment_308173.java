private Map<Student,Integer> cache = new HashMap<Student,Integer>();

private int complexOperation(Student s) {
    // See if we computed the rank of the student before
    Integer res = cache.get(s);
    if (res != null) {
        // We did! Just return the stored result:
        return res.intValue();
    }
    ... // do the real computation here
    // Save the result for future invocations
    cache.put(s, result);
    return result;
}