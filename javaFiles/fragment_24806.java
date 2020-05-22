long start = 0;
int runs = 10000; // enough to run for 2-10 seconds.
for(int i=-10000;i<runs;i++) {
    if(i == 0) start = System.nanoTime();
    // do test
}
long time = System.nanoTime() - start;
System.out.printf("Each XXXXX took an average of %,d ns%n", time/runs);