Apstate Class Activtiy:-

String value;
Bundle extras = getIntent().getExtras();
value = extras.getString("ListView_value");
setTitle(value);