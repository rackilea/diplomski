Button bA = (Button) findViewById(R.id.button);
    bA.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {


            new Thread(new Runnable() {

                public void run() {
                    try {
                        HttpClient httpclient = new DefaultHttpClient();

                        HttpGet request = new HttpGet();
                        URI Aswitch = new URI("http://192.168.1.186/a-switch.php");
                        request.setURI(Aswitch);
                        HttpResponse response = httpclient.execute(request);

                    } catch (ClientProtocolException e){
                        Log.e("log_tag", "ClientProtocol error");
                    } catch(IOException e){
                        Log.e("log_tag", "IO error");
                    } catch(URISyntaxException e) {
                        Log.e("log_tag", "URISytax error");
                    }

                }
            }).start();


        }
    });