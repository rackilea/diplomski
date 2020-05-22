try {
    Thread.sleep(1000); // 1000 ms = 1s however long you want it
} catch (InterruptedException e) {
    e.printStackTrace(); // It can cause exception so needs to be in a try-catch statement
}
//Run the method here
someMethod();