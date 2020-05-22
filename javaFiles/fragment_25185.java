//Setting the HashMaps

HashMap<String,String> item;
for(int i=0;i<Classes.length;i++){
    item = new HashMap<String,String>();
    item.put( "text1", Period[i]);
    item.put( "text2", Classes[i]);
    item.put( "text3", Grades[i]);
    list.add( item );
}

//...

//Setting the adapter
gradeListView.setAdapter(new new SimpleAdapter(this, item_list, R.layout.TwoLineListItem, new String[] { "text1","text2", "text3" }, new int[] {R.id.text1, R.id.text, R.id.text3}));