feedLayout = new LinearLayout(this);
feedLayout.setOrientation(LinearLayout.VERTICAL);
//LayoutInflater inflater = (LayoutInflater)  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
View v = getLayoutInflater().inflate(R.layout.list_feeds, feedLayout, false);
lstFeeds = (ListView) v.findViewById(R.id.listfeeds);
lstFeeds.setAdapter(new FeedsAdapter(this, android.R.layout.simple_list_item_1, lista));
feedLayout.addView(v);