String placeJSON =
            "{"+
              "\"location\": {" +
                "\"lat\": " + latitude + "," +
                "\"lng\": " + longitude +
               "}," + 
              "\"accuracy\":" + accuracy + "," +
               "\"name\": \"" + name + "\"," +
               "\"types\": [\"" + type + "\"]," +
               "\"language\": \"en\" " +
            "}";

        HttpRequest request;            
        request = t.buildPostRequest(new GenericUrl(PLACES_ADD_URL), ByteArrayContent.fromString(null, placeJSON));

        //Set the Google headers
        GoogleHeaders headers = new GoogleHeaders();

        headers.setContentType("application/json");     
        request.setHeaders(headers);

        request.getUrl().put("key", "....");
        request.getUrl().put("sensor", "true"); 
        request.execute();