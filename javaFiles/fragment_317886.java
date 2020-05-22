protected void onPostExecute(String file_url) {
    // dismiss the dialog once product deleted
    adapter.notifyDataSetChanged();
    mProgressDialog.dismiss();

}