Logger log = Logger.getAnonymousLogger();
int runs = 100 * 1000;
long start = System.nanoTime();
for(int i=0;i< runs;i++)
    log.info("Hello World! "+i);
long time = System.nanoTime() - start;
System.out.printf("Average log time was %,d ns%n", time/runs);