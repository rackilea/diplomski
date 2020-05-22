arams.put("OrderSummary", <your array list>);
           httpClient.post(APIURL.API_URL,params, new AsyncHttpResponseHandler() {
               @Override
               public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                   //your operations on success
               }

               @Override
               public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
               }
           });