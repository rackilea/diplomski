synchronized void PrintMsg(String msg) {
    System.out.println(msg);
    try {
        wait();
    } catch (InterruptedException e) {
        System.out.println("Exception");
    }
    System.out.println(msg);
    notify();
}