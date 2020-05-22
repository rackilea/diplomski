private class MyTask extends AsyncTask<Void, Void, Car> {
        @Override
        protected Car doInBackground() {
            // Create your Car here
            return car;
        }

        @Override
        protected void onPostExecute(Car car) {
            // This will be executed on UI thread after completion
        }
}