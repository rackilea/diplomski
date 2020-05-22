int timeTaken = 0;
int TIMEOUT = 30 * 60;

do {
    Thread.Sleep(1000);
    timeTaken = timeTaken + 1;
    reportelement = driver.findElements(...);
} while (timeTaken < TIMEOUT && reportelement.size != 1)