Intent intent=new Intent(CardViewActivity.this,PeopleListActivity.class);
Bundle bundle = new Bundle();
bundle.putString("key1",value1);
bundle.putString("key2",value2);
bundle.putString("key3",value3);
intent.putExtras(bundle)
startActvity(intent);