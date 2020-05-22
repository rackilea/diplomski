// Grant access to only 5 permits
Semaphore sp = new Semaphore(5);




    public void myMethod() {
        sp.acquire();
        //...
        sp.release();
    }