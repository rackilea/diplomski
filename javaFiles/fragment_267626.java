class b extends Thread {

    private final a _a;

    public b(a _a) {
        this._a = _a;
    }

    @Override
    public void run() {
        //now you can use _a here
    }
}