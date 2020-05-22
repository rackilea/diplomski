HttpClient httpclient = new HttpClient();
    File file = new File( "/home/abc/xyz/solar.jpg" );

    // DEBUG
    logger.debug( "FILE::" + file.exists() ); // IT IS NOT NULL        
    try
    {
    PostMethod filePost = new PostMethod( "http://localhost/myservice/upload" );

    Part[] parts = { new StringPart( "type","image"),new StringPart( "id","1"), new FilePart( "file", file ) };
    filePost.setRequestEntity( new MultipartRequestEntity( parts, filePost.getParams() ) );

    // DEBUG


        int response = httpclient.executeMethod( filePost );
        logger.info( "Response : "+response );
        logger.info( filePost.getResponseBodyAsString());
    }
    catch( HttpException e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    catch( IOException e )
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }