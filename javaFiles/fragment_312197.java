public void onButtonClick(View v) {
    EditText textInput = (EditText) findViewById(R.id.editText1);
    String code = textInput.getText().toString();

    new parseURL() {
        @Override
        protected void onPostExecute(List<String> list) {
            //use the list from parseURL to fill grid view
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

            gridView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }
    }.execute(code);
}