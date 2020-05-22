@GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response getMessage(){
        JSONObject finalJson = new  JSONObject ();
        JSONArray inputArray = new JSONArray();
            FreeDriversService f=new FreeDriversService();
            try{

            inputArray = f.executeFreeDrivers(); // this method return a JSONArray
            }catch(Exception e){
                System.out.println(e.toString());

            }
            finalJson.put("array",inputArray );
            return Response.status(200).entity(finalJson).build();
            }