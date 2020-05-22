TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost); //Assuming that you are setting your tabHost like this
Bundle extras = getIntent().getExtras();
if (extras != null) {
    String value = extras.getString("tab_index");
    if(value.equals("1"){
        tabHost.setCurrentTab(Integer.valueOf(value)); 
    }
    //and so on ...

}