public void sumCalculation (int param1, int param2, Callback callback) { 
    new AsyncTask<Integer, Void, Integer>() {

        @Override
        public Integer doInBackground(Integer... params) {
            int result = 0;
            for (Integer param : params) {
                result += param;
            }
            return result;                
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            callback.onDone(integer);
        }

    }.execute(param1, param2);
}