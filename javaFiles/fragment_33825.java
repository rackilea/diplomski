private void openHttpsConnection(String urlStr, Handler mhandler) throws IOException {
    HttpsURLConnection httpConn = null;
    String line = null;
    try {
        URL url = new URL(urlStr);
        URLConnection urlConn = url.openConnection();               
        if (!(urlConn instanceof HttpsURLConnection)) {
            throw new IOException ("URL is not an Https URL");
        }               
        httpConn = (HttpsURLConnection)urlConn;
        httpConn.setAllowUserInteraction(false);
        httpConn.setInstanceFollowRedirects(true);
        httpConn.setRequestMethod("GET");
        httpConn.setReadTimeout(50 * 1000);
        BufferedReader is =
                new BufferedReader(new InputStreamReader(httpConn.getInputStream()));                   

        while ((line = is.readLine( )) != null) {

                Message msg = Message.obtain();
                msg.what=1;  
                msg.obj=line;                       
                mhandler.sendMessage(msg);

        }               
    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch( SocketTimeoutException e){
        e.printStackTrace();
    } catch (IOException e) {

        e.printStackTrace();
        Message msg = Message.obtain();
            msg.what=2;
            BufferedInputStream in = new BufferedInputStream(httpConn.getErrorStream());

            line =new String(readStream(in));
            msg.obj=line;
            mhandler.sendMessage(msg);

    }
    finally {httpConn.disconnect();}

}