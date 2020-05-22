public boolean launchBrowserWithLocalResource(String resource)
{
    boolean answer = false;

    InputStream input = AppLauncher.class.getResourceAsStream(resource);

    if( input != null )
    {
        DataBuffer buffer = new DataBuffer();
        ByteArrayOutputStream output = null;

        try
        {
            byte[] temp = new byte[input.available()];

            while(true)
            {
                int bytesRead = input.read(temp);

                if( bytesRead == -1 )
                    break;

                buffer.write( temp, 0, bytesRead );
            }
            input.close();

            output = new ByteArrayOutputStream();

            Base64OutputStream boutput = new Base64OutputStream(output);

            output.write( "data:text/html;base64,".getBytes() );
            boutput.write( buffer.getArray() );

            boutput.flush();
            boutput.close();

            output.flush();
            output.close();

        } catch( IOException e )
        {
            Logger.log( "Caught IOException: " + e.getMessage() );
        }

        if( output != null )
        {
            BrowserSession bSession = Browser.getDefaultSession();
            bSession.displayPage( output.toString() );
            answer = true;
        }

    } else
    {
        Logger.log( "File not found: " + resource );
    }
    return answer;
}