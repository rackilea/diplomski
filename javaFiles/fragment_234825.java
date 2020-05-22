public String postData(String url, String xmlQuery) {

        final String urlStr = url;
        final String xmlStr = xmlQuery;
        final StringBuilder sb = new StringBuilder();

        Thread t1 = new Thread(new Runnable() {

            public void run() {

                HttpClient httpclient = MySSLSocketFactory.getNewHttpClient();

                HttpPost httppost = new HttpPost(urlStr);

                try {

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
                            1);
                    nameValuePairs.add(new BasicNameValuePair("xml", xmlStr));

                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpclient.execute(httppost);

                    Log.d("Vivek", response.toString());

                    HttpEntity entity = response.getEntity();
                    InputStream i = entity.getContent();

                    Log.d("Vivek", i.toString());
                    InputStreamReader isr = new InputStreamReader(i);

                    BufferedReader br = new BufferedReader(isr);

                    String s = null;

                    while ((s = br.readLine()) != null) {

                        Log.d("YumZing", s);
                        sb.append(s);
                    }

                    Log.d("Check Now", sb + "");

                } catch (ClientProtocolException e) {

                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }

        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Getting from Post Data Method " + sb.toString());

        return sb.toString();
    }