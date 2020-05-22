class HeavyWork extends AsyncTask<String,Void,Void>
{
    protected void onPreExecute()
    {
        pb.setVisibility(View.VISIBLE);
        trans.setVisibility(View.VISIBLE);
        ip.setVisibility(View.INVISIBLE);
        portt.setVisibility(View.INVISIBLE);
        conn.setVisibility(View.INVISIBLE);
    }
    protected Void doInBackground(String... urls)
    {
        start();
    return null;
    }
    protected void onPostExecute(Void a)
    {
        pb.setVisibility(View.INVISIBLE);
        trans.setVisibility(View.INVISIBLE);
        ip.setVisibility(View.VISIBLE);
        portt.setVisibility(View.VISIBLE);
        conn.setVisibility(View.VISIBLE);
        trans.setText("Waiting for files");
    }


}