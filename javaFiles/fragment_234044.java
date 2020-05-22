JSONObject returned = new JSONparser () {

    @Override
    protected void onProgressUpdate(Void... values) {
        // some logic here
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        // some logic here
    }

}.execute(method,httpurl,"").get();