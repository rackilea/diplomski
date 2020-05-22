public class CallWebService extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... params) {
        // Call Webservice for Get Menus
        WebServiceCall webServiceCall = new WebServiceCall(); // Custom class for call webservice
        BitmapFactory.Options options = new BitmapFactory.Options();

        // downsizing image as it throws OutOfMemory Exception for larger
        // images
        options.inSampleSize = 8;


        parameters = new ArrayList<NameValuePair>();

        parameters.add(new BasicNameValuePair("Name",uname12));
        parameters.add(new BasicNameValuePair("Address", uaddr12));
        parameters.add(new BasicNameValuePair("Email", en));
        parameters.add(new BasicNameValuePair("Qualification", uquali12));
        parameters.add(new BasicNameValuePair("Phoneno", ucontactno12));
        parameters.add(new BasicNameValuePair("Appliedfor", uappfor12));
        parameters.add(new BasicNameValuePair("Image", bitmapstring));
        parameters.add(new BasicNameValuePair("Resumeimage", bitmapstring1));
        parameters.add(new BasicNameValuePair("Operation", "i"));
        Log.i("param::",parameters.toString());
        response = webServiceCall.makeServiceCall(mUrlWebServiceLogin, parameters);


        Log.d("ResponseLogin:", response);



        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (progressDialog.isShowing())
            progressDialog.dismiss();

        if(response.contains("\"success\"")){
            session.createLoginSession(uname12);
            Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_SHORT).show();
            Intent in = new Intent(getApplicationContext(),InterView.class);
            in.putExtra("Name",uname12);

            startActivity(in);
            finish();


        }else{
            Toast.makeText(getApplicationContext(),"data not inserted",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        super.onPreExecute();
    }
}