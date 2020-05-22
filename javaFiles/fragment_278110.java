boolean logging = log.isDebugEnabled();

if (logging) {
    for (int i = 0; i < 1000; i++) {
        // stuff
        log.debug("Hi Mum!");
        // more stuff
    }
} else {
    for (int i = 0; i < 1000; i++) {
        // stuff
        // more stuff
    }
}