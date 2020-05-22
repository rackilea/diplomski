public class RestClient
{
    private ArrayList<NameValuePair> params;
    private ArrayList<NameValuePair> headers;

    private String url;

    private int responseCode;
    private String message;

    private String response;

    public String getResponse()
    {
        return response;
    }

    public String getErrorMessage()
    {
        return message;
    }

    public int getResponseCode()
    {
        return responseCode;
    }

    public RestClient(String url) {
        this.url = url;
        params = new ArrayList<NameValuePair>();
        headers = new ArrayList<NameValuePair>();
    }

    public void AddParam(String name, String value)
    {
        params.add(new BasicNameValuePair(name, value));
    }

    public void AddHeader(String name, String value)
    {
        headers.add(new BasicNameValuePair(name, value));
    }

    public void Execute(RequestMethod method) throws Exception
    {
        switch (method)
        {
        case GET:
        {
            // add parameters
            String combinedParams = "";
            if (!params.isEmpty())
            {
                combinedParams += "";
                for (NameValuePair p : params)
                {
                    String paramString = p.getName() + "" + URLEncoder.encode(p.getValue(),"UTF-8");
                    if (combinedParams.length() > 1)
                    {
                        combinedParams += "&" + paramString;
                    }
                    else
                    {
                        combinedParams += paramString;
                    }
                }
            }

            HttpGet request = new HttpGet(url + combinedParams);

            // add headers
            for (NameValuePair h : headers)
            {
                request.addHeader(h.getName(), h.getValue());
            }

            executeRequest(request, url);
            break;
        }
        case POST:
        {
            HttpPost request = new HttpPost(url);

            // add headers
            for (NameValuePair h : headers)
            {
                request.addHeader(h.getName(), h.getValue());
            }

            if (!params.isEmpty())
            {
                request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            }

            executeRequest(request, url);
            break;
        }
        }
    }

    private void executeRequest(HttpUriRequest request, String url) throws Exception
    {

        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters,15000);
        HttpConnectionParams.setSoTimeout(httpParameters, 15000);
        HttpClient client = new DefaultHttpClient(httpParameters);

        HttpResponse httpResponse;





            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null)
            {

                InputStream instream = entity.getContent();
                response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();
            }


    }

    private static String convertStreamToString(InputStream is)
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try
        {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public InputStream getInputStream(){
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters,15000);
        HttpConnectionParams.setSoTimeout(httpParameters, 15000);
        HttpClient client = new DefaultHttpClient(httpParameters);

        HttpResponse httpResponse;

        try
        {

               HttpPost request = new HttpPost(url);

            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null)
            {

                InputStream instream = entity.getContent();
                return instream;
             /*   response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();*/
            }

        }
        catch (ClientProtocolException e)
        {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
        catch (IOException e)
        {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
        return null;
    }
    public enum RequestMethod
    {
        GET,
        POST
    }
}