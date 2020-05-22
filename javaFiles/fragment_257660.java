SomeAnotherClass {

    // after initialize you can use this log, this log is same as in myApp class
    DBLog log;

    // 1 way: by sending to constructor
    public SomeAnotherClass(DBLog log) {
        this.log = log;
    }

    // 2 way: by calling set method
    public void setLog(DBLog log) {
        this.log = log;
    }
}