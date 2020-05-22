private AsyncResponse listener;

     @Override
        protected void onPostExecute(List<MainDataModel> dataModels) {
            listener.processFinish(dataModels);
        }