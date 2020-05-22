class TheTask extends AsyncTask<Void,Void,Void>
{

@Override
protected void onPostExecute(Void result) {
    // TODO Auto-generated method stub
    super.onPostExecute(result);

}

@Override
protected void onPreExecute() {
    // TODO Auto-generated method stub
    super.onPreExecute();

}

@Override
protected Void doInBackground(Void... params) {
    // TODO Auto-generated method stub
    getData();
    return null;
}
}