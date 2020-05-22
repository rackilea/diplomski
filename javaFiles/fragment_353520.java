List<String> a;
String[] b = new String[a.size()];
a.toArray(b);
Bundle c=new Bundle();
c.putStringArray("myList", b);     
Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
intent.putExtras(c)
startActivity(intent);
finish();