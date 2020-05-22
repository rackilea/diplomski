applicant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView < ? > adapterView, View view, int position, long id) {

        String clickedItemValue = (String) adapterView.getAdapter().getItem(position); // cast to String because your list datasource is a list String 
        // pass clickedItemValue to another activity
    }
});