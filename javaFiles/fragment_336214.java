URL url = new URL("http://localhost:8080");
    conn = (HttpURLConnection)url.openConnection();

    if ( conn != null ) {
    //Whatever you wants to post...                 
            String strPostData = "p1=Hello&p2=" + (new Date()).getTime();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept-Language", "en-GB,en;q=0.5");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-length", Integer.toString(strPostData.length()));
            conn.setRequestProperty("Content-Language", "en-GB");
            conn.setRequestProperty("charset", "utf-8");
            conn.setUseCaches(false);
            conn.setDoOutput(true);

            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            dos.writeBytes(strPostData);
            dos.flush();
            dos.close();

            int intResponse = conn.getResponseCode();
            System.out.println("\nSending 'POST' to " + url.toString() + 
                    ", data: " + strPostData + ", rc: " + intResponse);;
    }