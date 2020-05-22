private class AsyncCaller extends AsyncTask<Void, Void, Void>
{

@Override
protected void onPreExecute() {
    super.onPreExecute();

    //This runs on UI thread still.
}

@Override
protected Void doInBackground(Void... params) {

    //This runs in the background. Make your network operations here


    return null;
}

@Override
protected void onPostExecute(Void result) {
    super.onPostExecute(result);

 //This method will be running on UI thread
 //This is called when onBackground ha finished

}

}