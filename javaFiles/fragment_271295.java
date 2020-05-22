class MyTask extends AsyncTask<Void,Void,Void> {
        Class aclass;

        public MyTask(Class aclass){
             this.aclass=aclass;
        }

        @Override
        protected void onPreExecute() {
            // do something
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // do something
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent intent = new Intent(CommonPost.this, aclass);
            startActivity(intent);
        }
}