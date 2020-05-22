int tryCounter = 0;
while (!verifySystem(name, value)) {
    Thread.sleep(5 * 60 * 1000); // sleeping for 5 minutes
    tryCounter++
    if (tryCounter >= 10) {
        tryCounter = 0;
        // log your message here
    }
}