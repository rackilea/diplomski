GetJson json = new GetJson(Activity.this);
json.setOnResponseListener(new ResponseListener() {
       @Override
       public void onResponseReceived(String data) {
           // here you will get your response                                               
       }
});