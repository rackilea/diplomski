public static String shortUrl(String data) {
            String shortUrl = "";
            String serverResponse = "";
            try {
                // Set connection timeout to 5 secs and socket timeout to 10 secs
                HttpParams httpParameters = new BasicHttpParams();
                int timeoutConnection = 5000;
                HttpConnectionParams.setConnectionTimeout(httpParameters,
                        timeoutConnection);
                int timeoutSocket = 10000;
                HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

                HttpClient hc = new DefaultHttpClient(httpParameters);

                HttpPost request = new HttpPost(
                        "https://www.googleapis.com/urlshortener/v1/url");
                request.setHeader("Content-type", "application/json");
                request.setHeader("Accept", "application/json");

                JSONObject obj = new JSONObject();
                obj.put("longUrl", data);
                request.setEntity(new StringEntity(obj.toString(), "UTF-8"));

                HttpResponse response = hc.execute(request);

                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    response.getEntity().writeTo(out);
                    out.close();
                    serverResponse = out.toString();
                } else {
                    return null;
                }

                if (!Util.isNullOrEmpty(serverResponse)) {
                    JSONObject data = new JSONObject(serverResponse);
                    if (data != null) {
                        Constants.shortUrl = shortUrl = data.getString("id");
                    }
                } else {
                    shortUrl = shortUrl = data;
                }
            } catch (Exception e) {
                shortUrl = shortUrl = data;
            }
            return shortUrl;
    }