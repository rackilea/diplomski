// setting up the map, you might have to add more.
Map <String, String[]> map = new Map<String, String[]>();

map.put("normal",new String[]{"Wall Pushup", "Knees Pushup", "Regular Pushup","Pullup"}); 
map.put("beginner",new String[]{"Knees Pushup","Wall Pushup"});

// this would be the spinner that selects the "normal", "beginner" etc
spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
        String[] content = map.get(spinner.getSelectedItem().toString());
        if (content = null)
            myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.parent_layout, R.id.parent_txt, content));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
    }

});