protected String doInBackground(String... params) {
    String clientId = generateClientId();
    MqttAndroidClient client = // ....                 
    Semaphore s = new Semaphore(0);
    try {
       IMqttToken token = client.connect();
       token.setActionCallback(new IMqttActionListener() {
           @Override
           public void onSuccess() {
               // ...
               status = "True";
               s.release();
           }

           @Override
           public void onFailure() {
               // ...
               status = "False";
               s.release();
           }
       });
    } catch (MqttException e) {
         e.printStackTrace();
         s.release();
    }
    s.acquire();   // blocks until `s.release()` is invoked in callback
    return status;
}