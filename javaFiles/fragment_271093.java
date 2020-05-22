public void FLYNOTE_refresh() {
    int i;
    SharedPreferences Pref = getSharedPreferences("nnote", MODE_WORLD_READABLE); //созаётся файл настроек "nnote" и туда барыжиться вся хня
    key = Pref.getInt("number", 0); 
    String lv_arr[] = new String[key]; // One item smaller without "n0" 

    key++;
    for (i = 1; i < key; i++) {
        // Skip "n0" like this
        lv_arr[i - 1] = Pref.getString("n" + i, "none");           
    }

    textView1.setText(String.valueOf(key));

    listView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lv_arr));
    listView1.setTextFilterEnabled(true);
}