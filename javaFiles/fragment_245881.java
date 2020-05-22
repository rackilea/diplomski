listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //get here using position  
        String selected = (String) parent.getItemAtPosition(position);                     
    }
});