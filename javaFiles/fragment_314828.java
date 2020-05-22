public boolean onQueryTextChange(String newText) {
boolean success = false;

ArrayList<String> tempList = new ArrayList<>();
for (ItemClass temp : nomenclatureList){
    if (temp.getNomenclatureName().toLowerCase().contains(newText.toLowerCase())) {
        tempList.add(temp.getNomenclatureName());
    }
}
 ArrayAdapter<String> adapter = new ArrayAdapter<> ItemListGKI.this, android.R.layout.simple_list_item_1, tempList);
        listView.setAdapter(adapter);
        success = true;
return success;
}