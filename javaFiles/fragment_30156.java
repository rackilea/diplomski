LayoutInflater inflater = LayoutInflater.from(context);
View customView = inflater.inflate(R.layout.custom_view, null);
ImageView button = (ImageView) customView.findViewById(R.id.button1);
button.setOnClickListener(...);
ActionBar actionBar = getSupportActionBar();
actionBar.setDisplayShowCustomEnabled(true);
actionBar.setDisplayShowTitleEnabled(false);
actionBar.setCustomView(customView);