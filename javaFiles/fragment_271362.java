SharedPreferences sharedPref = this.getSharedPreferences("isfirsttime", Context.MODE_PRIVATE);
    if(getIntent().hasExtra("EXTRA_SESSION_ID"){
            int s = getIntent().getIntExtra("EXTRA_SESSION_ID",1);
            if(s==1)
            {
                sharedPref.edit().putBoolean("isfirsttime",false);
                Log.i("firsttime","NOT FIRST TIME");
            }
            else
            {
                Log.i("firsttime","FIRST TIME");
                Log.i("firsttime","intent value equals: " + s);
            }
}
            if(sharedPref.getBoolean("isfirsttime",true)) {
                startActivity(new Intent(this, explanationscreen.class));
                finish();
            }
            else
            {
                startActivity(new Intent(this, MapsActivity.class));
                finish();
            }