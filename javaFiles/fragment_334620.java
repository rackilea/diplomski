private byte[] callSOAPServer() {

    byte[] result = null;

    HttpParams httpParameters = new BasicHttpParams();
    // Set the timeout in milliseconds until a connection is established.
    int timeoutConnection = 15000;
    HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
    // Set the default socket timeout (SO_TIMEOUT)
    // in milliseconds which is the timeout for waiting for data.
    int timeoutSocket = 35000;
    HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

    DefaultHttpClient httpclient = new DefaultHttpClient(httpParameters);

    /*
     * httpclient.getCredentialsProvider().setCredentials( new
     * AuthScope("os.icloud.com", 80, null, "Digest"), new
     * UsernamePasswordCredentials(username, password));
     */
    HttpPost httppost = new HttpPost(SERVER_URL );
    httppost.setHeader("soapaction", SOAP_ACTION);
    httppost.setHeader("Content-Type", "text/xml; charset=utf-8");

    System.out.println("executing request" + httppost.getRequestLine());
   //now create a soap request message as follows:
    final StringBuffer soap = new StringBuffer();
    soap.append("\n");
    soap.append("");
   // this is a sample data..you have create your own required data  BEGIN
    soap.append(" \n");
    soap.append(" \n");
    soap.append("" + body);
    soap.append(" \n");
    soap.append(" \n");

    /* soap.append(body); */
     // END of MEssage Body
    soap.append("");
    Log.i("SOAP Request", ""+soap.toString());
   // END of full SOAP request  message
    try {
        HttpEntity entity = new StringEntity(soap.toString(),HTTP.UTF_8);
        httppost.setEntity(entity); 
        HttpResponse response = httpclient.execute(httppost);// calling server
        HttpEntity r_entity = response.getEntity();  //get response
        Log.i("Reponse Header", "Begin...");          // response headers
        Log.i("Reponse Header", "StatusLine:"+response.getStatusLine());
        Header[] headers = response.getAllHeaders();
        for(Header h:headers){
            Log.i("Reponse Header",h.getName() + ": " + h.getValue());
        }
        Log.i("Reponse Header", "END...");
        if (r_entity != null) {       
            result = new byte[(int) r_entity.getContentLength()];  
            if (r_entity.isStreaming()) {
                DataInputStream is = new DataInputStream(
                        r_entity.getContent());
                is.readFully(result);
            }
        }
    } catch (Exception E) {
        Log.i("Exception While Connecting", ""+E.getMessage());
        E.printStackTrace();
    }

    httpclient.getConnectionManager().shutdown(); //shut down the connection
    return result;
   }