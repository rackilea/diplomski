...
@Override
protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d("onPostExecute","response is: "+s); 

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
....