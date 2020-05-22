private String callServer(List<BasicNameValuePair> nameValuePairs,String path) {

        InputStream is = null;
        StringBuilder sb = null;
        String result = null;

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(path);


        //Your headers here
        //I'm afraid there are too much headers. Try cleaning and choosing only the neccessary ones.

        httppost.setHeader("Connection", "keep-alive");
        httppost.setHeader("Content-Length", "172");
        httppost.setHeader("X-GWT-Module-Base", "http://portus.puertos.es/Portus_RT/portusgwt/");
        httppost.setHeader("X-GWT-Permutation", "3DEDE3A69CBBE62D4C3F58BF7278538F");
        httppost.setHeader("Origin", "http://portus.puertos.es");
        httppost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36");
        httppost.setHeader("Accept", "*/*");
        httppost.setHeader("Referer", "http://portus.puertos.es/Portus_RT/?locale=es");
        httppost.setHeader("Accept-Encoding", "gzip,deflate");
        httppost.setHeader("Accept-Language", "en-US,en;q=0.8,es;q=0.6,ca;q=0.4");
        httppost.setHeader("AlexaToolbar-ALX_NS_PH", "AlexaToolbar/alxg-3.3");
        httppost.setHeader("Content-Type", "text/x-gwt-rpc; charset=UTF-8");
        httppost.setHeader("Host", "portus.puertos.es");    

        try {
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        // convert response to string
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            sb = new StringBuilder();
            sb.append(reader.readLine() + "\n");
            String line = "0";

            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }

            is.close();
            result = sb.toString();

        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());
        }

        return result;

    }