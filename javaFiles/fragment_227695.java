String[] from = new String[] {"row_1", "row_2"};
int[] to = new int[] { R.id.row1, R.id.row2};
List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();

for (int j = 0; j < sourceObj.length(); j++) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("row_1", sourceObj.data1);
        map.put("row_2", sourceObj.data2);
        fillMaps.add(map);
}

SimpleAdapter adapter = new SimpleAdapter(context, fillMaps, R.layout.yourlayoutname, from, to);
mListView.setAdapter(adapter);