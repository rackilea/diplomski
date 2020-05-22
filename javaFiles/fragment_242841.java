@Override
protected void onCreate(Bundle savedInstanceState) {
    ...// some init part 

    final MyAdapter adapter = new MyAdapter(schools, students);
    listView.setAdapter(adapter);

    listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
        @Override
        public boolean onChildClick(ExpandableListView parent, 
                   View v, int groupPosition, int childPosition, long id) {
            adapter.toggleSelection(groupPosition, childPosition);
            adapter.notifyDataSetInvalidated();
            return false;
        }
    });
}