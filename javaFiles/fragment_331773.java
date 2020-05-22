class Foo {
    // primitive, immutable
    private int theInt = 42;
    public int getTheInt() {
        return theInt;
    }
    // Object, immutable
    private String theString = "42";
    public String getTheString() {
        return theString;
    }
    // mutable!
    private StringBuilder theSB = new StringBuilder("42");
    public StringBuilder getTheSB() {
        // wrapping around
        return new StringBuilder(theSB);
    }
    // mutable!
    // java 7+ diamond syntax here
    private Map<String, String> theMap = new HashMap<>();
    {
        theMap.put("the answer is", "42");
    }
    public Map<String, String> getTheMap() {
        // will throw UnsupportedOperationException if you 
        // attempt to mutate through the getter
        return Collections.unmodifiableMap(theMap);
    }
    // etc.
}