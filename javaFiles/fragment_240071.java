private class MyTaskWithParams extends AsyncTask<String, Void, Car> {
        @Override
        protected Car doInBackground(String parameter) {
            // Create your Car using the String you passed
            return car;
        }

        @Override
        protected void onPostExecute(Car car) {
            // This will be executed on UI thread after completion
        }
}