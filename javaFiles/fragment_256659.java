private void loadList(int number) {
        ArrayList<String> sort = new ArrayList<String>();
        int start = number * NUM_ITEMS_PAGE;
        for (int i = start; i < (start) + NUM_ITEMS_PAGE; i++) {
            if (i < itemAList.size()) {
                sort.add(itemAList.get(i));
            } else {
                break;
            }
        }
       if(itemAdapter ==null){
            itemAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sort);
            itemList.setAdapter(itemAdapter);
       }
       else{
            itemAdapter.notifyDataSetChanged();
       }
}