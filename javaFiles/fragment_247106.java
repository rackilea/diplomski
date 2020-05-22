ConcurrentMap<String, String> values = new ConcurrentHashMap<>();

void someMethod(String string) {
    values.compute(string, (key,value) -> {
        if(value == null) value = key.toUpperCase(); // construct when not present
        // update value
        return value;
    });
}