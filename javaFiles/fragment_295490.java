listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     @Override
     public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        contactModels.get(position).checked = !contactModels.get(position).checked;
        adapter.notifyDataSetChanged();
     }
  });