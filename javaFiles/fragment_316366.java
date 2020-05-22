ActionBar actionBar = getSupportActionBar();
    actionBar.setDisplayShowCustomEnabled(true);
    actionBar.setDisplayShowTitleEnabled(false);
    actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#8B58A3")));

    LayoutInflater inflater = LayoutInflater.from(this);
    @SuppressLint("InflateParams") 
    View v = inflater.inflate(R.layout.titleview, null);

   actionBar.setCustomView(v);