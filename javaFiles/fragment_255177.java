ImageButton changeBgRed = (ImageButton) findViewById(R.id.bgRed); 
changeBgRed.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view){

        // Changed the line below to get the same preferences used in Home Screen
        SharedPreferences prefs = getSharedPreferences("Background", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("background", Color.RED);
        editor.commit();
    }
});