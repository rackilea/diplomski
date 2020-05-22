class Foo {
    @Inject Bar bar;  // requests the creation of bar
}

class Foo {
    @Inject Provider<Bar> barProvider; // does not cause the creation of bar

    void something() {
        Bar bar = barProvider.get(); // requests the creation of bar 
    }
}