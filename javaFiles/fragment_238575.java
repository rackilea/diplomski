public static void example() {
    SentryClient client = Sentry.getStoredClient();

    client.addShouldSendEventCallback(new ShouldSendEventCallback() {
        @Override
        public boolean shouldSend(Event event) {
            // decide whether to send the event

            for (Map.Entry<String, SentryInterface> interfaceEntry : event.getSentryInterfaces().entrySet()) {
                if (interfaceEntry.getValue() instanceof ExceptionInterface) {
                    ExceptionInterface i = (ExceptionInterface) interfaceEntry.getValue();
                    for (SentryException sentryException : i.getExceptions()) {
                        // this example checks the exception class
                        if (sentryException.getExceptionClassName().equals("foo")) {
                            // don't send the event
                            return false;
                        }
                    }
                }
            }

            // send event
            return true;
        }
    });
}