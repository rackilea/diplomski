class EZAsyncTask extends AsyncTask<Void, Void, String>
    {

        private AsyncTaskListener listener;

        public EZAsyncTask(AsyncTaskListener listener)
        {
            super();
            this.listener = listener;
        }

        @Override
        protected String doInBackground(Void... params)
        {
            //somethign to do
            return null;
        }

        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);
            listener.onCompletion(result);
        }

        public interface AsyncTaskListener
        {
            public void onCompletion(String result);
        }

    }