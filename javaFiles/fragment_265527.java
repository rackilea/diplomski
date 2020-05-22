void doSomething(Map<String, ? extends Number> map) {
    // Not allowed.  The caller might have passed a Map<String, Double>.
    map.put(String, Integer.valueOf(0));

    // Not allowed.  The caller might have passed a Map<String, Integer>.
    map.put(String, Double.valueOf(0));

    // Not allowed.  The caller might have passed a Map<String, Integer>
    // or Map<String, Double>.  This method has no way of knowing what the
    // actual restriction is.
    Number someNumber = generateNewNumber();
    map.put(String, someNumber);
}