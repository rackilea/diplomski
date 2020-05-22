@Override
    public void readycallback(int index_thread) {

    //this is your ready callback
    runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //this is your ready callback in main UI
//I do not remember if onPostExecute is in main UI thread
                }
            });
    }