public void FLYNOTE_refresh() 
{
    int i;
    SharedPreferences Pref = getSharedPreferences("nnote", MODE_WORLD_READABLE); //созаётся файл настроек "nnote" и туда барыжиться вся хня
    key = Pref.getInt("number", 0); 
    key++;
    lv_arr = new ArrayList<String>(); 

    for (i = 1; i < key; i++) {
        lv_arr.add(Pref.getString("n" + i, "none"));           
    }

    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr);
    listView1.setAdapter(adapter);

    listView1.setOnItemClickListener(new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            lv_arr.remove(position);
            adapter.notifyDataSetChanged();
        }
    });
}