abstract class Index {

    public Index() {
        // your code here
        // ...

        postConstruct();
    }

    void postConstruct() {
        // your post construction stuff
    }

    // assumed just one abstract method, may be a thousand like it
    abstract void foo(); 
}