public static String expandUrl(String shortenedUrl)  {
        URL url;
        String expandedURL = "";
        try {
            url = new URL(shortenedUrl);
            // open connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); 
            // stop following browser redirect
            httpURLConnection.setInstanceFollowRedirects(false);
            // extract location header containing the actual destination URL
            expandedURL = httpURLConnection.getHeaderField("Location");
            httpURLConnection.disconnect();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }    
         return expandedURL;
    }