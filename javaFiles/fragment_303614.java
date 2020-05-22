int index = 0;
String jsonResult = "[]";
Bundle extras = getIntent().getExtras();
if (extras != null) {
    index = extras.getInteger("index");
    jsonResult = extras.getString("json result");
}