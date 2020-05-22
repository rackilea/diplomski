intent = new Intent().setClass(this, SomeActivity.class);
  intent.putExtra("this_is_my_extra", "hello world!");

  spec = tabHost.newTabSpec("tagname1").setIndicator( ... );
  spec.setContent(intent);
  tabHost.addTab(spec);