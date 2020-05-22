ArrayList<String> list = new ArrayList<String>();

Intent intent = new Intent(this, SecondActivity.class);
Bundle bundle = new Bundle();
bundle.putParcelableArrayList("list",list);
intent.putExtras(bundle);       
this.startActivity(intent);