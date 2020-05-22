route("sample").from("jms://myqueue")
    // Handle SQL Exceptions by shutting down the route
    .onException(SQLException.class)
        .process(new Processor() {
            // This processor spawns a new thread that stops the current route
            Thread stop;

            @Override
            public void process(final Exchange exchange) throws Exception {
                if (stop == null) {
                    stop = new Thread() {
                        @Override
                        public void run() {
                            try {
                                // Stop the current route
                                exchange.getContext().stopRoute("sample");
                            } catch (Exception e) {}
                        }
                    };
                }
                // start the thread in background
                stop.start();
            }
        })
    .end()
    // Standard route processors go here
    .to(...);