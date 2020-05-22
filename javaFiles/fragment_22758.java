private class doRequest extends AsyncTask<String, String, String> {
    // Store error message
    private Exception e = null;

    public doRequest() {
    }

    @Override
    protected String doInBackground(String... args) {
        try {
            return process();
        } catch (Exception e) {
            this.e = e;    // Store error
        }

        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        ...
    }