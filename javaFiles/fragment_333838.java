protected void onPostExecute(String file_url) {
            if (pDialog != null) {
                if (pDialog.isShowing()) {
                    pDialog.dismiss();
                }
            }
        }