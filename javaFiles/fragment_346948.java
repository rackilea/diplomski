List<Map<String, String>> data = new ArrayList<Map<String, String>>();
for (RSSItem item : feed.getAllItems()) {
    Map<String, String> datum = new HashMap<String, String>(2);
    datum.put("title", item.getTitle());
    datum.put("date", item.getDate().toString());
    data.add(datum);
}
SimpleAdapter adapter = new SimpleAdapter(this, data,
                                          android.R.layout.simple_list_item_2,
                                          new String[] {"title", "date"},
                                          new int[] {android.R.id.text1,
                                                     android.R.id.text2});
itemList.setAdapter(adapter);