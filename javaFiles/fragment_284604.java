class AA {
    private AA() {}

    public static AA getInstance() {
        synchronized(AA.class) {
           AA obj = new AA();
           return obj;
        }
    }
}