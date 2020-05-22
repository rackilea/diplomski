private Foo(FooBuilder builder) {
    //get whatever you can find from the builder to fill the state of Foo
}
public static FooBuilder {
     private String filename;
     private File file;
     private InputStream stream;
     private int chunkSize;
     // getters and setters
     public Foo build() {
         return new Foo(this);
     }
}