for (int i = 0; i < 5; i++) {
    // ...
}
// i == 5 here
// this is an atomic operation and will succeed only for 1 thread
if (raceFinished.compareAndSet(false, true)) {
    // this is only printed if raceFinished was false beforehand
    System.out.println("WINNER IS  " + Thread.currentThread().getName());
}