public static String getURLData( String url ) {

    // creates a StringBuilder to store the data
    StringBuilder out = new StringBuilder();

    try {

        // creating the URL
        URL u = new URL( url );

        // openning a connection
        URLConnection uCon = u.openConnection();

        // getting the connection's input stream
        InputStream in = uCon.getInputStream();

        // a buffer to store the data
        byte[] buffer = new byte[2048];


        // try to insert data in the buffer until there is data to be read
        while ( in.read( buffer ) != -1 ) {

            // storing data...
            out.append( new String( buffer ) );

        }

        // closing the input stream
        in.close();            

        // exceptions...  
    } catch ( MalformedURLException exc )  {

        exc.printStackTrace();

    } catch ( IOException exc ) {

        exc.printStackTrace();

    } catch ( SecurityException exc ) {

        exc.printStackTrace();

    } catch ( IllegalArgumentException exc ) {

        exc.printStackTrace();

    } catch ( UnsupportedOperationException exc ) {

        exc.printStackTrace();

    }

    // returning data
    return out.toString();

}