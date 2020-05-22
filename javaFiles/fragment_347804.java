class LoadImageLoader extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... params) {
        // TODO Auto-generated method stub
         drawable = LoadImage("http://i.imgur.com/DvpvklR.png");
        return null;
    }
    @Override
    protected void onPostExecute(Void result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        imgview.setImageDrawable(drawable);

    }

}