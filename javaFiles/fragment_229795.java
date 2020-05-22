getSearchResult(searchString);
try {
    setListAdapter(new ArrayAdapter<String>(this, R.layout.phonebook_listview, mobile_nos));
} catch(Exception e) {
    e.printStackTrace();
}