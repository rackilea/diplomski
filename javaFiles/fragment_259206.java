private class ProgressTask1 extends AsyncTask<String, String, Boolean> {

    //.......... //your init
    @Override
    protected Boolean doInBackground(String... params) {
        //your background handle

        //publish to change UI
        String toShow = "your_string_here";
        publishProgress(toShow);
        //return ...; //your return value
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        //detect message and show it.
        //this.dialog.setMessage(values[0]);
    }
}