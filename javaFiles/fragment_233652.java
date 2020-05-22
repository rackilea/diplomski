public class Foo {
    private MemoryCache memoryCache;

    public Foo(MemoryCache memoryCache) {
        this.memoryCache = memoryCache;
    }

    public FSDataInputStream getObj(String hName, Path p) throws IOException {
        // ...
    }
}