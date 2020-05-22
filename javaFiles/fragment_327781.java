long startTime = System.nanoTime();
int i = 0;
for (; i < 10000; i++) {                                
    status = solver.check();
}
long elapsedTime = System.nanoTime() - startTime;