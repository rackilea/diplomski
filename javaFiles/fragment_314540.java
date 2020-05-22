Thread t = new Thread() {
    public void run() {
        //sending data to server
        response =
              httpClient.execute(httppost, new BasicResponseHandler()).trim();
    }
 };
 t.start();
 t.join();