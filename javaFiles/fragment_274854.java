public class ClassA {
    private ClassB someObject = new ClassB();

    public void FuncA() {
        synchronized(someObject) {
            //change some field of someObject
        }
    }

    // ...

    // BAD! Don't do this.
    public void FuncC() {
        // read some field of someObject
    }
}