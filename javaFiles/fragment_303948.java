long startTime = System.currentTimeMillis(); // Process start time

try {
    Thread.sleep(2000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

// Calculating elapse time
long elapsedTime = System.currentTimeMillis() - startTime;
// Incrementing the calendar time based on elapsed time
cal.setTimeInMillis(cal.getTime().getTime() + elapsedTime);