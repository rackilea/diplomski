private String getZipURL(){
    String result = "";
    InputStream is = null;
    try{
        String url = ZipURL;
        HttpPost httppost = new HttpPost(url);
        HttpParams httpParameters = new BasicHttpParams();

        int timeoutConnection = 3000;
        HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);

        int timeoutSocket = 3000;
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        DefaultHttpClient httpclient = new DefaultHttpClient(httpParameters);

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        is = entity.getContent();
    }catch(Exception e){
        Log.e("getZipURL", "Error in http connection "+e.toString());
        return null;
    }

    try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }
        is.close();

        result=sb.toString();
        return result;
    }catch(Exception e){
        Log.e("convertZipURL", "Error converting result "+e.toString());
        return null;
    }
}