public void populateSpinner(HashMap<Integer, String> map){
    List<StringWithTag> arrayList = new ArrayList<StringWithTag>();
    arrayList.add(new StringWithTag("Select Material", 0));

    for (Map.Entry<Integer, String> entry : map.entrySet()) {
        Integer key = Integer.parseInt(String.valueOf(entry.getKey()));
        String value = entry.getValue();
        arrayList.add(new StringWithTag(value, key));
    }

    ArrayAdapter<StringWithTag> arrayAdapter = new ArrayAdapter<StringWithTag>(this, android.R.layout.simple_spinner_item, arrayList);
    arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        materialSpinner.setAdapter(arrayAdapter);
}