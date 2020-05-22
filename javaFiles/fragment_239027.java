/**
    * This method copies the file from webdav to local system
    *
    * @param documentMetadata
    * @return
    */
   @Override
   public Document downloadFile( DocumentMetadata documentMetadata ) {
      Document document = new Document();
      String fileUrl = baseUrl + documentMetadata.getFilepath();

      ResponseEntity<byte[]> result = restTemplate.exchange(fileUrl, HttpMethod.GET, new HttpEntity<>( createHeaders( username, password )), byte[].class );


      return document;
   }

   private Void prepareDocument( ClientHttpResponse response, Document document, DocumentMetadata meta ) throws IOException {

      document.setName( meta.getFilename() );
      document.setFilePath( meta.getFilepath() );
      document.setFile( IOUtils.toByteArray( response.getBody() ) );
      return null;
   }

   public static HttpHeaders createHeaders( final String userName, final String password ) {
      log.debug( "SlateUtil.createHeaders" );
      return new HttpHeaders(){{
         String auth = userName + ":" + password;
         byte[] encodedAuth = Base64.encodeBase64(
               auth.getBytes( Charset.forName( "US-ASCII" )));
         String authHeader = "Basic " + new String( encodedAuth );
         set( "Authorization", authHeader );
      }};
   }