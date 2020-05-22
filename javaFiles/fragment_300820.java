String activity_title = getResources().getString(R.string.housing_button);
Intent intent = new Intent(this, DisplayDataActivity.class);
Bundle extras = new Bundle();
extras.putString("title", activity_title);
extras.putString("JSON_Object", JSONData);// so here JSONData always being null
intent.putExtras(extras);
startActivity(intent);