SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.gridviewdata, from, to);
    gridview.setAdapter(simpleAdapter);

    gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    public void onItemClick(AdapterView<?> parent, View v, final int position, long id) {

            aList.clear();