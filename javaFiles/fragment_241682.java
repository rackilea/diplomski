public void LoadTexturesAsync() {
    new AsyncTask<Void,Void, Void>(){
        @Override
        protected Void doInBackground(Void... params) 
        {
            //do your loading texture stuff here
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            if(_listener!=null){
                _listener.done();
            }
        }

    }.execute();
}