// Create intent
Intent intent = new Intent(this, MyActivity.class);
Bundle itemBundle = new Bundle();
itemBundle.putParcelable("item_extra", myItem);
intent.putExtras(itemBundle);
startActivity(intent);

// In the activities onCreate(Bundle savedInstanceState)
Item myItem = getIntent().getParcelableExtra("item_extra");