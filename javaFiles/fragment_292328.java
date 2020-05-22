protected void onPostExecute(String result) {
    // dismiss the dialog after getting all tracks
    pDialog.dismiss();

    ListAdapter adapter = new ArrayAdapter<Category>(
        CategoryCarActivity.this,     // the context
        android.R.layout.simple_list_item_1, // Simple list item - will toString() your data
        carList                       // The arraylist
    );

    // updating listview
    setListAdapter(adapter);

}