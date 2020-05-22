List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
params.add(new BasicNameValuePair("url_parameter_key", name));
params.add(new BasicNameValuePair("url_parameter_key", partner));

new NetworkRequest(new CallbackInterface() {

        @Override
        public void onRequestSuccess(JSONObject jsonObject) {
            Toast.makeText(getApplicationContext(),jsonObject,toString(),
                    Toast.LENGTH_LONG).show();
        }

    }, params).execute();