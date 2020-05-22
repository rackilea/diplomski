class Bar {
    <T> Bar(T object, Class<T> type) {
        // 'type' must represent a class to which 'object' is assignable,
        // albeit not necessarily 'object''s exact class.
        // ...
    }
}