public class BackGround_Task extends AsyncTask<Void, Void, Void> {
        private final ProgressDialog dialog = new ProgressDialog(
                YourClassName.this);

        // can use UI thread here
        protected void onPreExecute() {
            this.dialog.setMessage("Loading...");
            this.dialog.setCancelable(false);
            this.dialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Your Background Task

            return null;
        }

        protected void onPostExecute(Void result) {

            //What will you do after the completion of Background process

            if (this.dialog.isShowing()) {
                this.dialog.dismiss();
            }
        }
    }