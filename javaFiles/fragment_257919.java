ExpandableList.setOnGroupClickListener(new OnGroupClickListener() {
  @Override
  public boolean onGroupClick(ExpandableListView parent, View v,
                              int groupPosition, long id) { 
     return groupPosition == 0; //Index of item in your list that you want to be expandable
  }
});