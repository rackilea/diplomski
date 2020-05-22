@Override
protected String doInBackground(String... params) {
    backGroundExecuted = false;
    Log.d("doInBackground", "Start processing doInBackground");     

    HttpClient httpClient = null;
    HttpPost httpPost = null;
    HttpGet httpGet = null;


     if (httpMethodType == null || url == null) {
         Log.d("doInBackground" , "The URL and Method Type is mandatory, cannot be null - httpMethodType =" + httpMethodType + " and url =" + url);
         this.getApiResponse().setSuccess(false);
         this.getApiResponse().setResponseCode(HttpResponseCode.BAD_REQUEST);
         this.getApiResponse().setResponseDescription("The URL and Method Type is mandatory, cannot be null");
         return null;
     }

    try {

         //set timeout
         HttpParams httpParameters = new BasicHttpParams();
         HttpConnectionParams.setConnectionTimeout(httpParameters, TIME_OUT);
         HttpConnectionParams.setSoTimeout(httpParameters, SOCKET_TIME_OUT);

         httpClient = new DefaultHttpClient(httpParameters);
         HttpResponse httpResponse = null;

        if (httpMethodType.equals(HTTPMethodType.POST.toString())) {
            httpPost = new HttpPost(url);
            //setting json object to request.
            if (postParams != null) {
                AbstractHttpEntity entity = null;
                entity = new ByteArrayEntity(postParams.getBytes("UTF8"));
                if (httpContentType != null) {
                    entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, httpContentType));
                }
                httpPost.setEntity(entity);
            }
            httpResponse = httpClient.execute(httpPost);

        } else  if (httpMethodType.equals(HTTPMethodType.GET.toString()) || httpMethodType.equals(HTTPMethodType.PUT.toString())) {
            if (queryParams != null) {
                url = url + "?" + URLEncodedUtils.format(queryParams, "utf-8");
                Log.d(TAG ,"new URL :" + url);
            }
            httpGet = new HttpGet(url);
            httpResponse = httpClient.execute(httpGet); 
        }

        this.getApiResponse().setResponseCode(httpResponse.getStatusLine().getStatusCode());
        this.getApiResponse().setResponseDescription(httpResponse.getStatusLine().getReasonPhrase());
         if (this.getApiResponse().getResponseCode() != HttpStatus.SC_OK) { 
             this.getApiResponse().setSuccess(false);
             Log.w(getClass().getSimpleName(), 
                 "Error " + this.getApiResponse().getResponseCode() + " for URL " + url); 
             Log.w(getClass().getSimpleName(), 
                     "Error " +  this.getApiResponse().getResponseDescription() + " for URL " + url);
          }

         Log.d("doInBackground", "The API call executed and will check the response");
         HttpEntity entityResp = httpResponse.getEntity();
         if (entityResp != null) {
             this.getApiResponse().setResponse(appHelper.getStringFromInputStream(entityResp.getContent()));
             Log.d("doInBackground","The response is :" + this.getApiResponse().getResponse());
             this.getApiResponse().setSuccess(true);
         }

     } catch (UnsupportedEncodingException e1) {
         Log.e("doInBackground","Exception :" + e1.toString());
         this.getApiResponse().setSuccess(false);
         this.getApiResponse().setResponseCode(HttpResponseCode.BAD_REQUEST);
         this.getApiResponse().setResponseDescription("Exception :" + e1.toString());
            Log.e("doInBackground","Exception :" + e1.toString());
            e1.printStackTrace();
     } catch (Exception e) {
         Log.e("doInBackground","Exception :" + e.toString());
         this.getApiResponse().setSuccess(false);
         this.getApiResponse().setResponseCode(HttpResponseCode.BAD_REQUEST);
         this.getApiResponse().setResponseDescription("Exception :" + e.toString());
         if (httpPost != null && !httpPost.isAborted()) {
             httpPost.abort(); 
         }
     } finally {
         if (httpClient != null) {
             httpClient.getConnectionManager().shutdown();
         }
         backGroundExecuted = true;

     }
    return null;
}