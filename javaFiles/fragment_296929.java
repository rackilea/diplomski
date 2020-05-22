if (object instanceof Integer) {
    Foo.load((Integer) object); // Calls Foo.load(Integer)
} else if (object instanceof String) {
    Foo.load((String) object); // Calls Foo.load(String)
} else {
    Foor.load(object); // Calls Foo.load(Object)
}