public class PostTask extends AsyncTask<Void, Void, Void> {

    private static final String ENDPOINT = "http://yourendpoint/";

    PostTask() {
            //add here your variables that you need
    }

    @Override
    protected void doInBackground(Void... params) {
       this.doPost();
    }

    @Override
    protected void onPostExecute() {
        //do what you want when you are finished
    }

    private void doPost(){
        final RestTemplate restTemplate = new RestTemplate();
        final RequestObject request = new RequestObject();

        //parse the request to a format what is used by your endpoint (json, xml,..)
        HttpEntity<String> entity = new HttpEntity<String>(objectToString(request), createHeaders(authResp));
        final HttpEntity<String> response = restTemplate.exchange(ENDPOINT, HttpMethod.POST, entity, String.class);
     }
}