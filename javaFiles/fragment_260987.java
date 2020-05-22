public interface Lookup {
    // ...

    public String getValue(Key key);
}

public interface Key {
}

public MapKey implements Key {
    private String key;
    // ...
}

public GuavaKey implements Key {
    private String row, column;
    // ...
}