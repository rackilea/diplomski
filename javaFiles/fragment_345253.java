class SomeClass{
    private final SomeType field;

    SomeClass() {
        new Thread(new Runnable() {
            public void run() {
                SomeType copy = field; //copy could be null
                copy.doSomething(); //could throw NullPointerException
            }
        }).start();
        field = new SomeType();
    }
}