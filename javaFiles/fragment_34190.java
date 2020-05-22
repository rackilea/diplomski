new SomeTask(0).execute();

/** Inner class for implementing progress bar before fetching data **/
private class SomeTask extends AsyncTask<Void, Void, Integer> 
{
    private ProgressDialog Dialog = new ProgressDialog(yourActivityClass.this);

    @Override
    protected void onPreExecute()
    {
        Dialog.setMessage("Doing something...");
        Dialog.show();
    }

    @Override
    protected Integer doInBackground(Void... params) 
    {
        //Task for doing something 

        return 0;
    }

    @Override
    protected void onPostExecute(Integer result)
    {

        if(result==0)
        {
             //do some thing
        }
        // after completed finished the progressbar
        Dialog.dismiss();
    }
}