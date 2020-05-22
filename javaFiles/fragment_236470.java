for (int i = 0; i < 5; i++) {
        // TODO your request here
        boolean success = true; // TODO change to whatever outcome of your
                                // request
        if (success) {
            break;
        }
        else {
            try {
                Thread.sleep(10000l);
            }
            catch (InterruptedException ie) {
                // TODO handle interruptions if applicable
            }
        }
    }