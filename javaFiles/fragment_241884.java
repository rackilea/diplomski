@POST
      @Path("/postjson")
      @Consumes(MediaType.APPLICATION_JSON)
      public SimpleObject json(SimpleObject simpleObject){
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString="";
            try {
                jsonInString = mapper.writeValueAsString(simpleObject);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println(jsonInString);       
          return simpleObject;
      }