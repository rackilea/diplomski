private void callMetrics() {

    // .. some other code

    // send an email for unauthorized count
    long now = new Date().getTime();
    if (Integer.parseInt(unauthorizedCount) != 0 && satisfiesSinceLast(now)) {
        // send an email here
        lastSent = now;
    }
}

private void satisfiesSinceLast(long now) {
    return lastSent == -1 || now - lastSent > 30*60*1000;
}