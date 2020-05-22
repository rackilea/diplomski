@POST
    @Path("/message/")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public void postJsonMessage(@Body final CustomMessage[] data) {
        // process data...
    }