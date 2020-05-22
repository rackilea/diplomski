private AutoCompleteTextView mUrlEditText;
mUrlEditText = (AutoCompleteTextView) findViewById(R.id.UrlText);
mUrlEditText.setOnItemClickListener(new OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                    long arg3) {
        /* do something */
    }
});