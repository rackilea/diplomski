ActionBar actionBar = getSupportActionBar();
actionBar.setDisplayHomeAsUpEnabled(false);
actionBar.setDisplayShowCustomEnabled(true);
actionBar.setDisplayShowTitleEnabled(false);

LayoutInflater inflator = (LayoutInflater) this .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View view = inflator.inflate(R.layout.action_bar_layout, null);

actionBar.setCustomView(view);