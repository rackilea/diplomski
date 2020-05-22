private class PopulatingTask extends AsyncTask<Void, Void, Boolean> {

         private ProgressDialog dialog;
         private MainActivity activity;

        public PopulatingTask (MainActivity activity) {
            this.activity = activity;
            dialog = new ProgressDialog(activity);
        }

        @Override
        protected void onPreExecute() {
            this.dialog.setMessage("Loading data...");
            this.dialog.show();
        }

        @Override
        protected Boolean doInBackground(Void... args) {
            try{    

                activity.populateEvents();

                events = activity.getEvents();

                // preparing list data
                prepareListData();

                return true;

             } catch (Exception e){
                Log.e("tag", "error", e);
                return false;
             }
          }

        @Override
        protected void onPostExecute(Boolean success) {

            listAdapter = new ExpandableListAdapter(activity, listDataHeader, listDataChild);

            // setting list adapter
            expListView.setAdapter(listAdapter);

            // dismiss the dialog
            if (dialog.isShowing()) {
                dialog.dismiss();
            }

            if (success) {
                Toast.makeText(activity, "OK", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(activity, "Error", Toast.LENGTH_LONG).show();
            }
        }
    }