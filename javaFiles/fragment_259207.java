private class ProgressTask1 extends AsyncTask<String, Void, Boolean> {
    //.......... //your init

    @Override
    protected Boolean doInBackground(String... params) {
        //your background handle
        //return ...;//your return value
    }


    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        String toShow = "your_string_here";
        //this.dialog.setMessage(toShow);
    }
}