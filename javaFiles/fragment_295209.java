public class RetrievePollenTask extends AsyncTask<Integer, Void, Pollen>
{

    protected Pollen doInBackground(String... params)
    {
        Pollen pollenObject = new Pollen(19104);
        return pollenObject;
    }

    protected void onPostExecute(Pollen result) {
         textview.setText(pollenObject.getCity());
     }

}