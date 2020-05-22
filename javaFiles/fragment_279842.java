AtomicInteger failedAmount = new AtomicInteger(0);

failedAmount = myMap.putIfAbsent("username", failedAmount);

if (failedAmount.incrementAndGet() >= THRESHOLD) {
    // possible brute force detected! alert admin / slow down login
    // / or whatever
}