// in runnable class:
public void join() throws InterruptedException {
    t.join();
}

// in main:
R1.join();
R2.join();
R3.join();

// Sum of results from all threads:
System.out.println(runnable.arr);
double totalSum = 0; // also use double instead of int here
for (double i : runnable.arr) {
    totalSum += i;
}
long endTime_par = System.currentTimeMillis();