HttpPost httppost = new HttpPost(url);
HttpParams httpParameters = new BasicHttpParams();
int timeoutConnection = 3000;
HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
int timeoutSocket = 5000;
HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

DefaultHttpClient httpClient = new DefaultHttpClient(httpParameters);
HttpResponse response = httpClient.execute(httppost);