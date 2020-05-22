boolean logging = log.isDebugEnabled();

    for (int i = 0; i < 1000; i++) {
        // stuff
        if (logging) { 
            log.debug("Hi Mum!");
        }
        // more stuff
    }