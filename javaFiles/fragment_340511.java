lvitemslist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
        CheckedTextView ctv = view.findViewById(R.id.ctv);
        ctv.setCheckMarkDrawable(android.R.drawable.checkbox_on_background);
        db.deletedata(tablename,ctv.getText().toString());
        viewdata(tablename);
    }
}