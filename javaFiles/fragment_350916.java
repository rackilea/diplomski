public void processThis() {
    lockA.lock();
    // here the control should be switched to another thread
    System.out.println("resource A -Thread1");

    lockB.lock();
    ...