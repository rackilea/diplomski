public boolean isValidJSON(final String json) {
   boolean valid = false;
   try {
      final JsonParser parser = new ObjectMapper().getJsonFactory()
            .createJsonParser(json);
      while (parser.nextToken() != null) {
      }
      valid = true;
   } catch (JsonParseException jpe) {
      jpe.printStackTrace();
   } catch (IOException ioe) {
      ioe.printStackTrace();
   }

   return valid;
}