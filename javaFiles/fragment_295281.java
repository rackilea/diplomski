//LoggingINInterceptor
    cxfEndpoint.getInInterceptors().add(new LoggingInInterceptor() {
        @Override
        public void handleMessage(Message message) throws Fault {
            LOGGER.info("Request body: ${body}");
        }

        @Override
        public void handleFault(Message message) {
            LOGGER.info("Request fault body: ${body}");
        }
    });

    //LoggingOutInterceptor
    cxfEndpoint.getOutInterceptors().add(new LoggingOutInterceptor() {
        @Override
        public void handleMessage(Message message) throws Fault {
            LOGGER.info("Response body: ${body}");
        }

        @Override
        public void handleFault(Message message) {
            LOGGER.info("Response fault body: ${body}");
        }
    });