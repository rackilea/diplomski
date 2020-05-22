listView.setAdapter(arrayAdapter);
listView.setTextFilterEnabled(true);
searchView.setIconifiedByDefault(false);
searchView.setOnQueryTextListener(this);
searchView.setSubmitButtonEnabled(true);
searchView.setQueryHint("Search...");


@Override
public boolean onQueryTextChange(String newText) {
    if (TextUtils.isEmpty(newText)) {
        listView.clearTextFilter();
    } else {
        listView.setFilterText(newText.toString());
    }
    return true;
}