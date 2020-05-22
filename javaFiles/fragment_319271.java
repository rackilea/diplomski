ObjectMapper mapper = new ObjectMapper();
      JavaType type = mapper.getTypeFactory().constructCollectionType( List.class, iClass );
      List<T> lObjects = null;

      JsonArray lResponse = ltarget.request( MediaType.APPLICATION_JSON ).get( JsonArray.class );
      try {
         lObjects = mapper.readValue( lResponse.toString(), type );
      } catch ( JsonParseException e ) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch ( JsonMappingException e ) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch ( IOException e ) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }