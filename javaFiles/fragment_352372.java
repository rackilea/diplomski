for (int i = 0; i <ls.size() ; i++) {
        if (e.toLowerCase().contains(editText.getText().toString())){
            lsFiltered.add(ls.get(i));
        }
}
adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,lsFiltered);
listView.setAdapter(adapter);