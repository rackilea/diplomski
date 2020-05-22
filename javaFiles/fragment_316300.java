@Override
   protected void onPostExecute(Document  result) {

        if (dialog.isShowing()) {
            dialog.dismiss();
          }
         // do your work here after doInBackground execution
          ArrayList<LatLng> directionPoint = md.getDirection(result);
          ....

     }