@PathParam("topic")
        Broadcaster broadcaster;

        @Suspend(contentType = "application/json")
        @GET
        public SuspendResponse<String> search() {
            if (broadcaster.getAtmosphereResources().size() == 0) {
                broadcaster.scheduleFixedBroadcast(new Callable<String>() {
                    public String call() throws Exception {
                    // Wait for the connection to be suspended.

                    broadcaster.broadcast("broadcast");
                    return null;
                    }
                    }, 5000, TimeUnit.MILLISECONDS);
            }
            return new SuspendResponse.SuspendResponseBuilder<String>()
            .broadcaster(broadcaster)
            .outputComments(true)
            .addListener(new EventsLogger() {
                    @Override
                    public void onSuspend(
                    AtmosphereResourceEvent event) {
                        super.onSuspend(event);

                    }
            }).build();
        }