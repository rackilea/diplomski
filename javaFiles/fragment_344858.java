Thread t = new Thread(){
            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    HttpsURLConnection c=(HttpsURLConnection) new URL(url.trim()).openConnection();

                    Log.d(TAG, "Parameter value is " + "Basic " + DatatypeConverter.printBase64Binary((email+":"+password).getBytes()));

                    c.setRequestProperty("Authorization","Basic "+DatatypeConverter.printBase64Binary((email+":"+password).getBytes()));
                    InputStream iStream=null;
                    try {
                        Log.d(TAG, "Trying to get the input stream..");

                        iStream=c.getInputStream();
                    } catch (Exception e) {

                        e.printStackTrace();

                        iStream=c.getErrorStream();
                    }

                    Log.d(TAG, "Trying to read...");
                    InputStreamReader iStreamReader=new InputStreamReader(iStream);

                    Log.d(TAG, "Buffering...");
                    BufferedReader bReader=new BufferedReader(iStreamReader);
                    String result="";
                    String line="";

                    Log.d(TAG, "About to parse results...");
                    while ((line=bReader.readLine())!=null) {
                        Log.d(TAG, "Line is " + line);
                        result +=line+"\n"; 

                    }

                    Log.d(TAG, "Output is:  " + result);

                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }                   

                super.run();
            }

        };

        t.start();