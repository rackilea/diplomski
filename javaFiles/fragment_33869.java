String xml = "<!DOCTYPE ourapi SYSTEM \"dtdName.dtd\">\n" +
            "<otherStuff>"\n+
            "</otherStuff>";


RequestBody requestBody = 
         RequestBody.create(MediaType.parse("text/plain"), xml);

return ourApi.post(requestBody).execute();