textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

        displayField.setText(map.get(adapterView.getItemAtPosition(position).toString()));

    }

});