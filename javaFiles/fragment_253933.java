String yourJsonString = ...

 InputStream jsonInputStream = new ByteArrayInputStream(yourJsonString.getBytes());
 db.update("document_id",
           jsonInputStream,
           file.length(),
           null);