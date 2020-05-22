private static class MyAsync extends AsyncTask <Void, Integer, String> {
....

@Override
protected void onProgressUpdate(Integer... progress) {
    alertDialog.setMessage("The graphs are loading...\n"+progress[0]+"% Completed");
}

@Override
protected String doInBackground(Void... params) {
    incrementor = 0;
    for ( int i = 0; i<day; i++){ 
        publishProgress(getThePercent);
        ....