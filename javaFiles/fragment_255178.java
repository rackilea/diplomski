@Override
protected void onResume(){
    super.onResume();
    background = (RelativeLayout) findViewById(R.id.rootLayout);
    SharedPreferences settings = getSharedPreferences("Background", Context.MODE_PRIVATE);
    if(settings.getInt("background", Color.WHITE) == Color.RED)
        background.setBackgroundColor(Color.RED);
    else
        background.setBackgroundColor(Color.WHITE);