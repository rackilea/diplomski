@Override
    protected String doInBackground(Void... params) {
        Log.v("TAGGG", "IN doInBackground");
        msg = "Error: ";
        int i = 0;
        while (i <= 50) {
            try {
                Thread.sleep(50);
                publishProgress(i);
                i++;
            }
            catch (Exception e) {
                Log.i(TAGGG, e.getMessage());
            }
        }
        return msg;
    }