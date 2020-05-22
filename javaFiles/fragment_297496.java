setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {              
        String selectedName = (String) parent.getItemAtPosition(position);
        // if you used a HashMap
        String ID = exampleHashMap.get(selectedName);
    }
}