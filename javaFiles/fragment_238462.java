public void handleEvent(Event evt) {
        System.err.println("starting handleEvent");
        try {
            Y.externalMethod();
        } finally {
            System.err.println("finished handleEvent");
        }
    }