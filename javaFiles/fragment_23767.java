String[] listItems = {"Colour", "Font Size",};
 ListView lv = (ListView) findViewById(R.id.settings_list);

 lv.setAdapter(new ArrayAdapter<String>
 (this, android.R.layout.simple_list_item_1, listItems));

 lv.setOnItemClickListener(new OnItemClickListener()
 {
  public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        if(listItems[position].equlas("Font Size"))
        {
          Context context = getApplicationContext();
          CharSequence text = "Clicked";
          int duration = Toast.LENGTH_SHORT;

          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }
});