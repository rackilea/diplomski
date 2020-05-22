public void fetchJSONChild(final GetChildList callBack){

        final List<String> child = new ArrayList<String>();
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {

                try {

                    URL url = new URL("http://192.168.x.xx:xxxx/childform_list/0.0.0.0/8069/new_db/admin/123456");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(30000 /* milliseconds */);
                    conn.setConnectTimeout(50000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    //conn.setRequestProperty("User-Agent", "GYUserAgentAndroid");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoInput(true);
                    //conn.setUseCaches (false);
                    // Starts the query
                    if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {

                        conn.setRequestProperty("Connection", "close"); 
                    }
                    conn.connect();

                    System.out.println("Before url.openStream()");
                    InputStream stream = conn.getInputStream();//.openStream();
                    System.out.println("After url.openStream()");
                    String data = convertStreamToString(stream);
                    // for examole data = "1,2,3";

                    child.addAll(Arrays.asList(data.split(","));
                    readAndParseJSON(data);
                    stream.close();

                    callBack.onGetChildList(child);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
        });
        thread.start(); 
    }