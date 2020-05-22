try {


        HttpClient httpclient = new DefaultHttpClient();

        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters, 2000);
        HttpConnectionParams.setSoTimeout(httpParameters, 2000);
        httpclient = new DefaultHttpClient(httpParameters);

        HttpGet request = new HttpGet(Constants.CHECK_UPDATE_URL);

        String responseString = null;

        HttpResponse response = httpclient.execute(request);
        StatusLine statusLine = response.getStatusLine();

        if (statusLine.getStatusCode() == HttpStatus.SC_OK) {

            // Logging Server Responded

            LogActions.systemActions("Server Responded");

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);
            out.close();


                            //do your tasks here

        }

    } catch (Exception e) {

        Log.e("Exception", "An impossible exception", e);
    }