public MyClass getInstance() {
    if (uniqueInstance == null) {
        synchronized(MyClass.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new MyClass();
            }
        }
    }
    return uniqueInstance;
}