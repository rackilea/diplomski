for(int i = 0; i < 30000; i++) {

    ...

    try {
        Thread.sleep(100);
    }
    catch(InterruptedException e) {
        // do something with e
    }
}