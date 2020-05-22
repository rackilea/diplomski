@POST
    @Produces("application/pdf")
    @Path("/hello")
    @Consumes("application/x-www-form-urlencoded")
    public Response producePDF(MultivaluedMap<String, String> params)

Iterator<String> it = params.keySet().iterator();
            String theKey = null;
            while(it.hasNext()){
                theKey = it.next();
                log.info("Here is a Key: "+theKey);
                if(theKey.equals("filename")){
                    fileName = params.getFirst(theKey);
                    System.out.println("Key: "+theKey);
                }
            }