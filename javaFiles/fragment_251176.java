onException(Exception.class)
        .process(new Processor() {

        @Override
        public void process(Exchange exchange) throws Exception {
            // place to add logic to handle exception
            Throwable caught = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, 
                    Throwable.class);
            logger.error("FATAL ERROR - ", caught);
        }
    })
    .handled(true); // if I don't give handled(true), it will keep reprocessing the file again and again.


    from("file:" + pathToFile + "?noop=true")
    // rest of the route