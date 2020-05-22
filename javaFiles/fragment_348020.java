public void scheduleNumbers(int[] randomNumbers, int speed, int amount) {
final AtomicInteger curNumber = new AtomicInteger();
long initialDelay = 1000;
final Runnable setNumber = () -> {

    currentNumberLab.setText(Integer.toString(randomNumbers[curNumber.incrementAndGet()]));
    System.out.println("Set to " + randomNumbers[curNumber.get()]);
};