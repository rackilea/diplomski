private class AsyncCallWS extends AsyncTask<Void, Void, String> {

    @Override
    protected void onPreExecute() {
        Log.i(TAG, "onPreExecute");
    }
    @Override
    protected String doInBackground(Void... params) {
        Log.i(TAG, "doInBackground");

            SoapPrimitive response = null;
                try {
                    SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
                    SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                    soapEnvelope.dotNet = true;
                    soapEnvelope.setOutputSoapObject(Request);
                    HttpTransportSE transport = new HttpTransportSE(URL);
                    transport.call(SOAP_ACTION, soapEnvelope);
                    response = (SoapPrimitive) soapEnvelope.getResponse();
                    result1= response.toString();
                } catch (Exception ex) {
                    Log.e(TAG, "Error: " + ex.getMessage());
                }
        return response.toString();
    }
    @Override
    protected void onPostExecute(String result) {
        Log.i(TAG, "onPostExecute");
    }

}