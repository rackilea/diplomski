public void run() throws java.io.IOException {
    int count = 1;
    Fraction myInterMid;
    while (stdin.hasNext()) {
        try {
            runOnce(count++);
            System.out.print("Intermediate results: ");
            while (!myQueue.isEmpty()) {
                myInterMid = (Fraction) myQueue.remove();
                System.out.print(myInterMid.toString());
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
        clear(myStack, myQueue);
    }
    System.out.println("Normal Termination of Program 3.");
}