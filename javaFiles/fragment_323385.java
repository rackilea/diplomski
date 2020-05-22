public boolean isReachable(String url) {
       if (url == null)
           return false;
       try {
        URL u = new URL(url);
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        // HttpURLConnection.setFollowRedirects(true); REMOVE THIS LINE
        huc.setRequestMethod("GET");
        huc.setReadTimeout(readTimeOut);
        huc.setInstanceFollowRedirects(false); // ADD THIS LINE
        huc.connect();
        int code = 0;
        if (u.getHost() != null)
            code = huc.getResponseCode();   
        huc.disconnect();
        return (200 <= code && code <= 399);
        }catch(Exception ee) {
        System.out.println(ee);
        return false;
        }
    }