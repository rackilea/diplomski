try {
    x.t.join();
    y.t.join();
} catch (InterruptedException e) {
    System.out.println("Main thread Interrupted");
}