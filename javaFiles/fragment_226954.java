class Outer<T> {
    class Inner{
        T t;//Added this extra line
    }

    static class Nested {
        Inner inner; 
    }
}