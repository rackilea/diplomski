public static MyClass {
    private final FIRST_LOCK = new Object();
    private final SECOND_LOCK = new Object();

    public void m1() {
        synchronized(FIRST_LOCK) {
        } 
    }

    public void m2() {
        synchronized(SECOND_LOCK) {    
        } 
    }

    public void m3() {
        synchronized(FIRST_LOCK) {
            synchronized(SECOND_LOCK) {
            }
        } 
    }
}