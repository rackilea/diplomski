mButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

new UploadImageTask().execute(); // initialize asynchronous task

}});

//Now implement Asynchronous Task


public class Get_User_Data extends AsyncTask<Void, Void, Void> {

            private final ProgressDialog dialog = new ProgressDialog(
            MyActivity.this);

    protected void onPreExecute() {
        this.dialog.setMessage("Loading...");
        this.dialog.setCancelable(false);
        this.dialog.show();
    }
        @Override
        protected Void doInBackground(Void... params) {

                    uploadImage(); // inside the method paste your file uploading code
            return null;
        }

        protected void onPostExecute(Void result) {

            // Here if you wish to do future process for ex. move to another activity do here

            if (dialog.isShowing()) {
                dialog.dismiss();
            }

        }
    }