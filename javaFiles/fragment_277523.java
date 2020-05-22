public String doRequest( Map<String, String> params, String content ) throws IOException
{
    ByteArrayOutputStream paramBytes = new ByteArrayOutputStream();

    for ( Entry<String, String> param: params.entrySet() )
        paramBytes.write( nvpair( param.getKey() , param.getValue() ) );

    Packet beginRequest = new Packet( FCGI.BEGIN_REQUEST, FCGI.NULL_REQUEST_ID, new byte[] { 0, FCGI.RESPONDER, FCGI.KEEP_CONN, 0, 0, 0, 0, 0 } );
    Packet requestParams = new Packet( FCGI.PARAMS, FCGI.NULL_REQUEST_ID, paramBytes.toByteArray() );
    Packet requestParamsEOF = new Packet( FCGI.PARAMS, FCGI.NULL_REQUEST_ID, new byte[] {} );
    Packet requestContent = new Packet( FCGI.STDIN, FCGI.NULL_REQUEST_ID, content.getBytes( "UTF-8" ) );
    Packet requestContentEOF = new Packet( FCGI.STDIN, FCGI.NULL_REQUEST_ID, new byte[] {} );

    OutputStream stream = socket.getOutputStream();

    stream.write( beginRequest.getBytes() );
    stream.write( requestParams.getBytes() );
    stream.write( requestParamsEOF.getBytes() );        
    stream.write( requestContent.getBytes() );
    stream.write( requestContentEOF.getBytes() );      

    return readResponse();
}