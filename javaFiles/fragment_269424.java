String result = null;
HttpGet request = new HttpGet(some_uri);

// As Jeff Sharkey does in the android-sky example, 
// use request.setHeader to optionally set the User-Agent header.

HttpParams httpParams = new BasicHttpParams();
int some_reasonable_timeout = (int) (30 * DateUtils.SECOND_IN_MILLIS);
HttpConnectionParams.setConnectionTimeout(httpParams, some_reasonable_timeout);
HttpConnectionParams.setSoTimeout(httpParams, some_reasonable_timeout);
HttpClient client = new DefaultHttpClient(httpParams);

try
{
  HttpResponse response = client.execute(request);
  StatusLine status = response.getStatusLine();
  if (status.getStatusCode() == HttpStatus.SC_OK)
  {
    ResponseHandler<String> responseHandler = new BasicResponseHandler();
    result = responseHandler.handleResponse(response);
  }
  else
  {
    // Do something else, if wanted.
  }
}
catch (ClientProtocolException e)
{
  Log.e(LOG_TAG, "HTTP Error", e);
  // Do something else, if wanted.
}
catch (IOException e)
{
  Log.e(LOG_TAG, "Connection Error", e);
  // Do something else, if wanted.
}
finally
{
  client.getConnectionManager().shutdown();
}

// Further parse result, which may well be JSON.