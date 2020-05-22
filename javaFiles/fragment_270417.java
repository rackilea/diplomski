DataObject data = new DataObject();
data.someData = "test";
data.someMoreData = "test2";
Intent intent = new Intnent(this, MyActivity.class);
intent.setAction(MyActivity.MY_CUSTOM_ACTION);
intent.putExtra(MyActivity.DATA_KEY,data);
intent.putExtra(SearchManager.QUERY, "Query");
startActivity(intent);